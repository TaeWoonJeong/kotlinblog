package com.twgroup.kotlinblog.model

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor
import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int?=null

    var title:String?=null

    var content:String?=null

    var count:Int=0

    @CreationTimestamp
    var createdDate :Timestamp?=null
}