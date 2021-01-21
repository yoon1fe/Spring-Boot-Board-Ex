package org.zerock.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    // Board 삭제 시 댓글들도 삭제
    @Modifying      // JPQL을 이용해서 update, delete 실행하기 위해 필요한 어노테이션
    @Query("delete from Reply r where r.board.bno =:bno")
    void deleteByBno(Long bno);

    // 게시물로 댓글 목록 가져오기
    List<Reply> getRepliesByBoardOrderByRno(Board board);
}
