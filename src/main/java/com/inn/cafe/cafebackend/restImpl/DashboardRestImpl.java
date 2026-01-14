package com.inn.cafe.cafebackend.restImpl;

import com.inn.cafe.cafebackend.rest.DashboardRest;
import com.inn.cafe.cafebackend.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DashboardRestImpl implements DashboardRest {

    DashboardService dashboardService;
    public DashboardRestImpl(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getCount() {
        return dashboardService.getCount();
    }

}
