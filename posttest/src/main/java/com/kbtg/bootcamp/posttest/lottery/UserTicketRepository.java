package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTicketEntity, Long> {

    List<UserTicketEntity> findByUserId(Integer userId);

    void deleteByUserIdAndTicketId(Integer integer, LotteryEntity lotteryEntity);
}
