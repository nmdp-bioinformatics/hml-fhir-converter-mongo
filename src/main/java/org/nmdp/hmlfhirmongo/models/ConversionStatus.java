package org.nmdp.hmlfhirmongo.models;

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

import org.bson.types.ObjectId;
import org.joda.time.DateTime;

import java.io.Serializable;


public class ConversionStatus implements Serializable {
    private String id;
    private String hmlId;
    private String fhirId;
    private Status status;
    private Boolean complete;
    private Boolean success;
    private Integer size;
    private DateTime startTime;
    private DateTime endTime;

    public ConversionStatus(String hmlId, Status status, Integer size) {
        this.complete = false;
        this.success = false;
        this.startTime = new DateTime();
        this.hmlId = hmlId;
        this.status = status;
        this.size = size;
        this.fhirId = new ObjectId().toString();
        this.endTime = new DateTime();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHmlId() {
        return hmlId;
    }

    public void setHmlId(String hmlId) {
        this.hmlId = hmlId;
    }

    public String getFhirId() {
        return fhirId;
    }

    public void setFhirId(String fhirId) {
        this.fhirId = fhirId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConversionStatus)) return false;

        ConversionStatus that = (ConversionStatus) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getHmlId() != null ? !getHmlId().equals(that.getHmlId()) : that.getHmlId() != null) return false;
        if (getFhirId() != null ? !getFhirId().equals(that.getFhirId()) : that.getFhirId() != null) return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getComplete() != null ? !getComplete().equals(that.getComplete()) : that.getComplete() != null)
            return false;
        if (getSuccess() != null ? !getSuccess().equals(that.getSuccess()) : that.getSuccess() != null) return false;
        return getSize() != null ? getSize().equals(that.getSize()) : that.getSize() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getHmlId() != null ? getHmlId().hashCode() : 0);
        result = 31 * result + (getFhirId() != null ? getFhirId().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getComplete() != null ? getComplete().hashCode() : 0);
        result = 31 * result + (getSuccess() != null ? getSuccess().hashCode() : 0);
        result = 31 * result + (getSize() != null ? getSize().hashCode() : 0);
        return result;
    }
}
