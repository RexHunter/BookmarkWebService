package com.rexxie.OfflineBookmarksWebService.web.controllers;

import com.rexxie.OfflineBookmarksWebService.db.modules.models.EtsBookmarkList;
import com.rexxie.OfflineBookmarksWebService.db.modules.services.EtsBookmarkService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EtsBookmarksController {
    private EtsBookmarkService etsBookmarkService;

    @Autowired
    public void setEtsBookmarkService(EtsBookmarkService etsBookmarkService) {
        this.etsBookmarkService = etsBookmarkService;
    }

    @RequestMapping(value = "/bookmarks/duringThePeriod", method = RequestMethod.GET)
    public EtsBookmarkList getETSBookmarksDuringThePeriod(@RequestParam("first") String first,
                                                          @RequestParam("last") String last,
                                                          @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                          @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return etsBookmarkService.getBookmarksDuringThePeriod(new DateTime(first), new DateTime(last), limit, offset);
    }

    @RequestMapping(value = "/bookmarks/lastFewDays/{days}", method = RequestMethod.GET)
    public EtsBookmarkList getETSBookmarksByLastFewDays(@PathVariable("days") Integer days,
                                                        @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                        @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return etsBookmarkService.getBookmarksByLastFewDays(days, limit, offset);
    }

    @RequestMapping(value = "/bookmarks/byDate/{date}", method = RequestMethod.GET)
    public EtsBookmarkList getETSBookmarksByDate(@PathVariable("date") String date,
                                                 @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                 @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return etsBookmarkService.getBookmarksByDate(new DateTime(date), limit, offset);
    }

}
