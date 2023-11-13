package com.win.whitelist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.win.whitelist.Entity.Techstaff;

@Repository
public interface TechstaffRepository extends JpaRepository<Techstaff, Long>   {
    

}
