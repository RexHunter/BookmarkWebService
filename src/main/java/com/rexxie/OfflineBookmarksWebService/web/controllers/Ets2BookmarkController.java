package com.rexxie.OfflineBookmarksWebService.web.controllers;

import com.rexxie.OfflineBookmarksWebService.db.modules.ets2.services.Ets2BookmarksService;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.Bookmark;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Ets2BookmarkController {

    private Ets2BookmarksService ets2BookmarksService;

    @Autowired
    public void setEts2BookmarksService(Ets2BookmarksService ets2BookmarksService) {
        this.ets2BookmarksService = ets2BookmarksService;
    }

    @RequestMapping(value = "/bookmarks/ets2/duringThePeriod", method = RequestMethod.GET)
    public List<Bookmark> getETS2BookmarksDuringThePeriod(@RequestParam("first") String first,
                                                          @RequestParam("last") String last,
                                                          @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                          @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets2BookmarksService.getBookmarksDuringThePeriod(new DateTime(first), new DateTime(last), limit, offset);
    }

    @RequestMapping(value = "/bookmarks/ets2/lastFewDays/{days}", method = RequestMethod.GET)
    public List<Bookmark> getETS2BookmarksByLastFewDays(@PathVariable("days") Integer days,
                                                        @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                        @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets2BookmarksService.getBookmarksByLastFewDays(days, limit, offset);
    }

    @RequestMapping(value = "/bookmarks/ets2/byDate/{date}", method = RequestMethod.GET)
    public List<Bookmark> getETS2BookmarksByDate(@PathVariable("date") String date,
                                                        @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                        @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets2BookmarksService.getBookmarksByDate(new DateTime(date), limit, offset);
    }
}
