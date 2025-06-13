package com.EventManagementPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EventManagementPortal.entity.Events;

public interface EventRepository extends JpaRepository<Events, Long> {}