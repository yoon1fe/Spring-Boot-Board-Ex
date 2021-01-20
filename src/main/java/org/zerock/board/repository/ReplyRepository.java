package org.zerock.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.board.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Modifying      // JPQL을 이용해서 update, delete 실행하기 위해 필요한 어노테이션
    @Query("delete from Reply r where r.board.bno =:bno")
    void deleteByBno(Long bno);

}
