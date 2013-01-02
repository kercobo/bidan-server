package org.ei.drishti.contract;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.joda.time.LocalDate;

import static org.apache.commons.lang.StringUtils.isNotBlank;

public class AnteNatalCareInformation {
    private String caseId;
    private String anmIdentifier;
    private String ancVisitNumber;
    private String numberOfIFATabletsGiven;
    private String visitDate;
    private String ttDose;

    public AnteNatalCareInformation(String caseId, String anmIdentifier, int visitNumber, String visitDate) {
        this.caseId = caseId;
        this.anmIdentifier = anmIdentifier;
        this.ancVisitNumber = String.valueOf(visitNumber);
        this.visitDate = visitDate;
    }

    public String caseId() {
        return caseId;
    }

    public AnteNatalCareInformation withNumberOfIFATabletsProvided(String numberOfTablets) {
        this.numberOfIFATabletsGiven = String.valueOf(numberOfTablets);
        return this;
    }

    public AnteNatalCareInformation withTTDose(String ttDose) {
        this.ttDose = ttDose;
        return this;
    }

    public boolean ifaTablesHaveBeenProvided() {
        return numberOfIFATabletsProvided() > 0;
    }

    public int visitNumber() {
        return coerceToInt(ancVisitNumber);
    }

    public LocalDate visitDate() {
        return LocalDate.parse(visitDate);
    }

    public String anmIdentifier() {
        return anmIdentifier;
    }

    public int numberOfIFATabletsProvided() {
        return coerceToInt(numberOfIFATabletsGiven);
    }

    private int coerceToInt(String x) {
        return x == null || x.isEmpty() ? 0 : Integer.parseInt(x);
    }

    public Boolean wasTTShotProvided() {
        return isNotBlank(ttDose);
    }

    public String ttDose() {
        return ttDose;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(o, this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

