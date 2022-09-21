package com.youngwu.todolistv2.model;

import com.youngwu.todolistv2.constant.FinishFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "to_do_id")
    private long toDoId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "isFinish")
    @Enumerated(EnumType.STRING)
    private FinishFlag isFinish;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;
}
