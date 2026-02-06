package edu.rutgers.rusafe.model.enums;

public enum StatusType {
    REPORTED,     // submitted by user
    UNDER_REVIEW, // seen by admin/officer
    VERIFIED,     // confirmed
    RESOLVED,     // no longer active
    REJECTED      // false or invalid
}
