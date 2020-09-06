package nl.kortekaas.Stagemanagement.controller;

import nl.kortekaas.Stagemanagement.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) { this.testService = testService; }

    @GetMapping("/stagemanager")
    public String stagemanagerAccess() { return testService.generateStagemanagerContent(); }

    @GetMapping("/deputy")
    public String deputyAccess() { return testService.generateDeputyContent(); }

    @GetMapping("/assistant")
    public String assistantAccess() { return testService.generateAssContent(); }

    @GetMapping("/crew")
    public String crewAccess() { return testService.generateCrewContent();  }

    @GetMapping("/props")
    public String propsAccess() { return testService.generatePropsContent();  }

    @GetMapping("/creative")
    public String creativeAccess() { return testService.generateCreativeContent();  }

    @GetMapping("/production")
    public String productionAccess() { return testService.generateProductionContent();  }
}
