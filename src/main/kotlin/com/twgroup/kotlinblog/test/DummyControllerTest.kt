package com.twgroup.kotlinblog.test

import org.springframework.dao.EmptyResultDataAccessException

import com.twgroup.kotlinblog.model.Board
import com.twgroup.kotlinblog.repository.BoardRepository

import org.springframework.data.web.PageableDefault

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
class DummyControllerTest {
    @Autowired
    lateinit var boardRepository: BoardRepository

    @GetMapping("/test/boards")
    fun list(): List<Board?>? {
        return boardRepository.findAll()
    }

    @GetMapping("/test/board")
    fun pageList(@PageableDefault(size = 2, sort = ["id"], direction = Sort.Direction.DESC) pageable: Pageable): List<Board> {
        //sort="id" 를 arrayOf("id") 로 바꾸고 ["id"] 로 바꿈
        var boardsPage : Page<Board> = boardRepository.findAll(pageable)
        var boards : List<Board> = boardsPage.content
        return boards
    }

    @GetMapping("/test/board/{id}")
    operator fun get(@PathVariable id: Int): Board {
        return boardRepository.findById(id)
            .orElseThrow{IllegalArgumentException("해당 유저의 아이디는 없습니다.")}
    }

    @PostMapping("/test/board")
    fun post(@RequestBody board: Board): String {
        println(board.id)
        println(board.title)
        println(board.content)
        println(board.count)
        println(board.content)
        boardRepository.save(board)
        return "글쓰기 완료"
    }

    @Transactional
    @PutMapping("/test/board/{id}")
    fun update(@PathVariable id: Int, @RequestBody requestBoard: Board): Board {
        val board: Board = boardRepository.findById(id).orElseThrow { IllegalArgumentException("수정에 실패하였습니다.") }
        board.title = requestBoard.title
        board.content = requestBoard.content
        return board
    }

    @DeleteMapping("/test/board/{id}")
    fun delete(@PathVariable id: Int): String {
        try {
            boardRepository.deleteById(id)
        } catch (e: EmptyResultDataAccessException) {
            return "삭제 실패 해당 아이디가 DB에 없습니다."
        }
        return "삭제되었습니다.$id"
    }
}