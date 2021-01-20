package org.zerock.board.entity;

/**
 * 시간 처리를 위한 BaseEntity 클래스
 * - 엔티티 객체의 등록 시간과 최종 수정 시간을 담
 */

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass   // 해당 어노테이션이 적용된 클래스는 테이블로 생성되지 않음. 실제 테이블은 BaseEntity 클래스를 상속한 엔티티의 클래스로 생성됨.
@EntityListeners(value = {AuditingEntityListener.class})    // JPA 내부에서 엔티티 객체가 생성/변경되는 것을 감지. 이를 통해 regDate, modDate가 지정됨.
@Getter
abstract class BaseEntity {

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;
}
