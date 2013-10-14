package org.wora.spi.types;

import java.util.EnumSet;
import java.util.UUID;

import org.wora.types.Gender;

public class IdentityQueryCriterion {
    EnumSet<Gender> sex;
    String fname;
    String lname;
    UUID id;
}
