package org.zerock.board.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")   // @ToString 은 항상 exclude ??
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

//    @ManyToOne  // N:1 관계 (게시판 N : 작성자 1)
    @ManyToOne (fetch = FetchType.LAZY) // 명시적으로 Lazy 로딩 지정
    private Member writer;  // 연관 관계 지정!
}
