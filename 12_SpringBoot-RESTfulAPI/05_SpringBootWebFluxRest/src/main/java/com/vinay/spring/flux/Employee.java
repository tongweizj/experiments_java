package com.vinay.spring.flux;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor  // 代替手写的无参构造
@AllArgsConstructor // 代替手写的全参构造
@Document(collection = "employees") // 指定 MongoDB 集合名
public class Employee {
    
    @Id
    private int empId;
    
    private String empName;
    private String jobTitle;
    private double salary;
    
    // 所有的 Getter、Setter、toString、equals、hashCode 都消失了，
    // 但你在其他类里依然可以正常调用它们！
}
