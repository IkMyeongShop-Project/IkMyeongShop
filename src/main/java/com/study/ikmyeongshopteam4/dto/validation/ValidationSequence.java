package com.study.ikmyeongshopteam4.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ValidationGroups.NotBlankGroup.class,
        ValidationGroups.SizeGroup.class,
        ValidationGroups.PatternGroup.class,
        Default.class
})
public interface ValidationSequence {}
