package org.nmdp.hmlfhirmongo.models;

/**
 * Created by Andrew S. Brown, Ph.D., <andrew@nmdp.org>, on 8/1/17.
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

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FhirSubmission implements Serializable {
    private String id;
    private Boolean complete;
    private Boolean error;
    private String exception;
    private Date startTime;
    private Date endTime;
    private Map<String, DiagnosticReport> diagnosticReports;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Map<String, DiagnosticReport> getDiagnosticReports() {
        return diagnosticReports;
    }

    public void setDiagnosticReports(Map<String, DiagnosticReport> diagnosticReports) {
        this.diagnosticReports = diagnosticReports;
    }

    public void addDiagnosticReport(String id, DiagnosticReport report) {
        if (this.diagnosticReports == null) {
            this.diagnosticReports = new HashMap<>();
        }

        this.diagnosticReports.put(id, report);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FhirSubmission that = (FhirSubmission) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (complete != null ? !complete.equals(that.complete) : that.complete != null) return false;
        if (error != null ? !error.equals(that.error) : that.error != null) return false;
        if (exception != null ? !exception.equals(that.exception) : that.exception != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        return diagnosticReports != null ? diagnosticReports.equals(that.diagnosticReports) : that.diagnosticReports == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (complete != null ? complete.hashCode() : 0);
        result = 31 * result + (error != null ? error.hashCode() : 0);
        result = 31 * result + (exception != null ? exception.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (diagnosticReports != null ? diagnosticReports.hashCode() : 0);
        return result;
    }
}
