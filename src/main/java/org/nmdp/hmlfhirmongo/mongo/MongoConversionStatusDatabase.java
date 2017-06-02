package org.nmdp.hmlfhirmongo.mongo;

/**
 * Created by Andrew S. Brown, Ph.D., <andrew@nmdp.org>, on 6/2/17.
 * <p>
 * hml-fhir-mongo
 * Copyright (c) 2012-2017 National Marrow Donor Program (NMDP)
 * <p>
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 3 of the License, or (at
 * your option) any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
 * License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library;  if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.
 * <p>
 * > http://www.fsf.org/licensing/licenses/lgpl.html
 * > http://www.opensource.org/licenses/lgpl-license.php
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.nmdp.hmlfhirmongo.config.MongoConfiguration;
import org.nmdp.hmlfhirmongo.models.ConversionStatus;
import org.nmdp.hmlfhirmongo.models.Status;

public class MongoConversionStatusDatabase extends MongoDatabase {

    private final MongoCollection<Document> collection;

    public MongoConversionStatusDatabase(MongoConfiguration config) {
        super(config.getConnectionString(), config.getPort(), config.getDatabaseName());
        collection = super.database.getCollection("conversionStatus");
    }

    public ConversionStatus save(ConversionStatus conversionStatus) {
        Document document = toDocument(conversionStatus);
        collection.insertOne(document);
        conversionStatus.setId(document.get("_id").toString());
        return conversionStatus;
    }

    public void update(String id, Boolean success, String fhirId) {
        BasicDBObject update = new BasicDBObject();

        update.append("$set", new BasicDBObject().append("fhirId", fhirId));
        update.append("$set", new BasicDBObject().append("status", success ? Status.COMPLETE : Status.ERROR));
        update.append("$set", new BasicDBObject().append("endTime", new DateTime()));
        update.append("$set", new BasicDBObject().append("success", success));

        collection.updateOne(Filters.eq("_id", new ObjectId(id)), update);
    }

    public Document get(String id) {
        return collection.find(Filters.eq("_id", new ObjectId(id))).first();
    }

    public String toJson(ConversionStatus conversionStatus) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.toJson(conversionStatus);
    }

    private Document toDocument(ConversionStatus conversionStatus) {
        return Document.parse(toJson(conversionStatus));
    }
}
