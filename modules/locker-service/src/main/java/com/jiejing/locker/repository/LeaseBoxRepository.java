package com.jiejing.locker.repository;

import com.jiejing.locker.domains.LeaseBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

/**
 * Created by Bogle on 2016/9/2.
 */
public interface LeaseBoxRepository extends JpaRepository<LeaseBox, Integer> {

    @Query(nativeQuery = true,
            value = "select \n" +
                    "DISTINCT locker_lease_box.id,\n" +
                    "locker_lease_box.created_by,\n" +
                    "locker_lease_box.created_date,\n" +
                    "locker_lease_box.last_modified_by,\n" +
                    "locker_lease_box.last_modified_date,\n" +
                    "locker_lease_box.cabinet_id,\n" +
                    "locker_lease_box.box_id,\n" +
                    "locker_lease_box.box_size_id,\n" +
                    "locker_lease_box.charge_standard_id,\n" +
                    "locker_lease_box.cabinet_code,\n" +
                    "locker_lease_box.cabinet_name,\n" +
                    "locker_lease_box.box_code,\n" +
                    "locker_lease_box.box_name,\n" +
                    "locker_lease_box.box_size_code,\n" +
                    "locker_lease_box.box_size_name,\n" +
                    "locker_lease_box.charge_type,\n" +
                    "locker_lease_box.cycle_time,\n" +
                    "locker_lease_box.price,\n" +
                    "locker_lease_box.order_id,\n" +
                    "locker_lease_box.box_state,\n" +
                    "locker_lease_box.check_type,\n" +
                    "locker_lease_box.timeout,\n" +
                    "locker_lease_box.fetch_time,\n" +
                    "locker_lease_box.retreat_id\n" +
                    "from locker_lease_box\n" +
                    "LEFT JOIN locker_action_log ON locker_action_log.lease_id = locker_lease_box.id\n" +
                    "LEFT JOIN locker_lease_info ON locker_lease_info.id = locker_action_log.lease_info_id\n" +
                    "LEFT JOIN sys_dictionary ON sys_dictionary.id = locker_lease_info.info_type\n" +
                    "WHERE locker_lease_box.cabinet_id = :cabinet_id\n" +
                    "AND locker_lease_box.box_state='DQ'\n" +
                    "AND locker_action_log.opt_type='CX'\n" +
                    "AND sys_dictionary.`code` = :code\n" +
                    "ORDER BY locker_lease_box.created_date DESC"
    )
    Stream<LeaseBox> findAll(@Param("cabinet_id") Integer cabinetId, @Param("code") String code);
}
