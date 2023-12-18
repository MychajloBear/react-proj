package de.ukrainewin.store.controller;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import de.ukrainewin.store.service.LocalizationService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
//@RequestMapping("api")
    public class GeneralPageInfoController {

    @Autowired
    private LocalizationService localizationService;

    @Value("${build.version}")
    private String buildVersion;

    @Value("${localization.header}")
    private String localizedHeader;

	@GetMapping("api/header")
	public String getHeader(@RequestParam Optional<String> search) {
		return localizationService.getLocalizedString("header");
            //localizedHeader;
	}
}

//--------------------------------------------------------------
/* 
@RestController
public class PageInfoController {

    @Autowired
    private LocalizationService localizationService;

    @GetMapping("/page-info")
    public PageInfo getPageInfo() {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setHeader(localizationService.getLocalizedString("header"));
        pageInfo.setCaption(localizationService.getLocalizedString("caption"));
        // Add more properties as needed
        return pageInfo;
    }
} */