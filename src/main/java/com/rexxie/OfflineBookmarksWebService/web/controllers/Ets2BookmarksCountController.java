package com.rexxie.OfflineBookmarksWebService.web.controllers;

import com.rexxie.OfflineBookmarksWebService.db.modules.ets2.services.Ets2BookmarksCountService;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.BookmarkCount;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Ets2BookmarksCountController {

    private Ets2BookmarksCountService ets2BookmarksCountService;

    @Autowired
    public void setEts2BookmarksService(Ets2BookmarksCountService ets2BookmarksCountService) {
        this.ets2BookmarksCountService = ets2BookmarksCountService;
    }

    @RequestMapping(value = "/bookmarks/ets2/duringThePeriod/count", method = RequestMethod.GET)
    public List<BookmarkCount> getETS2BookmarksDuringThePeriod(@RequestParam("first") String first,
                                                               @RequestParam("last") String last,
                                                               @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                               @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets2BookmarksCountService.getBookmarksCountDuringThePeriod(new DateTime(first), new DateTime(last), limit, offset);
    }

    @RequestMapping(value = "/bookmarks/ets2/lastFewDays/{days}/count", method = RequestMethod.GET)
    public List<BookmarkCount> getETS2BookmarksCountByLastFewDays(@PathVariable("days") Integer days,
                                                                  @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                                  @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets2BookmarksCountService.getBookmarksCountByLastFewDays(days, limit, offset);
    }

    @RequestMapping(value = "/bookmarks/ets2/byDate/{date}/count", method = RequestMethod.GET)
    public List<BookmarkCount> getETS2BookmarksCountByDate(@PathVariable("date") String date,
                                                           @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                           @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets2BookmarksCountService.getBookmarksCountByDate(new DateTime(date), limit, offset);
    }

}
