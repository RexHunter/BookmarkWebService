package com.rexxie.OfflineBookmarksWebService.web.controllers;

import com.rexxie.OfflineBookmarksWebService.db.modules.ets1.services.Ets1BookmarksCountService;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.BookmarkCount;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Ets1BookmarksCountController {

    private Ets1BookmarksCountService ets1BookmarksCountService;

    @Autowired
    public void setEts1BookmarksService(Ets1BookmarksCountService ets1BookmarksCountService) {
        this.ets1BookmarksCountService = ets1BookmarksCountService;
    }

    @RequestMapping(value = "/bookmarks/ets1/duringThePeriod/count", method = RequestMethod.GET)
    public List<BookmarkCount> getETS1BookmarksCountDuringThePeriod(@RequestParam("first") String first,
                                                                    @RequestParam("last") String last,
                                                                    @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                                    @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets1BookmarksCountService.getBookmarksCountDuringThePeriod(new DateTime(first), new DateTime(last), limit, offset);
    }

    @RequestMapping(value = "/bookmarks/ets1/lastFewDays/{days}/count", method = RequestMethod.GET)
    public List<BookmarkCount> getETS1BookmarksCountByLastFewDays(@PathVariable("days") Integer days,
                                                        @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                        @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets1BookmarksCountService.getBookmarksCountByLastFewDays(days, limit, offset);
    }

    @RequestMapping(value = "/bookmarks/ets1/byDate/{date}/count", method = RequestMethod.GET)
    public List<BookmarkCount> getETS1BookmarksCountByDate(@PathVariable("date") String date,
                                                 @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                 @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets1BookmarksCountService.getBookmarksCountByDate(new DateTime(date), limit, offset);
    }

}
