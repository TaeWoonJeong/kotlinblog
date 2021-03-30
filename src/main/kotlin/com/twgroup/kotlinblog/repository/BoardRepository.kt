package com.twgroup.kotlinblog.repository

import com.twgroup.kotlinblog.model.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board,Int>{

}