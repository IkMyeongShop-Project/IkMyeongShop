package com.study.ikmyeongshopteam4.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    private int id;
    private String username;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
