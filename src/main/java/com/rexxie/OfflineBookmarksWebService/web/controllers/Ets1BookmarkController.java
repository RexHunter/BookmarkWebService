package com.rexxie.OfflineBookmarksWebService.web.controllers;

import com.rexxie.OfflineBookmarksWebService.db.modules.ets1.services.Ets1BookmarksService;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.Bookmark;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Ets1BookmarkController {

    private Ets1BookmarksService ets1BookmarksService;

    @Autowired
    public void setEts1BookmarksService(Ets1BookmarksService ets1BookmarksService) {
        this.ets1BookmarksService = ets1BookmarksService;
    }

    @RequestMapping(value = "/bookmarks/ets1/duringThePeriod", method = RequestMethod.GET)
    public List<Bookmark> getETS1BookmarksDuringThePeriod(@RequestParam("first") String first,
                                                          @RequestParam("last") String last,
                                                          @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                          @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets1BookmarksService.getBookmarksDuringThePeriod(new DateTime(first), new DateTime(last), limit, offset);
    }

    @RequestMapping(value = "/bookmarks/ets1/lastFewDays/{days}", method = RequestMethod.GET)
    public List<Bookmark> getETS1BookmarksByLastFewDays(@PathVariable("days") Integer days,
                                                        @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                        @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets1BookmarksService.getBookmarksByLastFewDays(days, limit, offset);
    }

    @RequestMapping(value = "/bookmarks/ets1/byDate/{date}", method = RequestMethod.GET)
    public List<Bookmark> getETS1BookmarksByDate(@PathVariable("date") String date,
                                                 @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
                                                 @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) throws Exception {
        return ets1BookmarksService.getBookmarksByDate(new DateTime(date), limit, offset);
    }

    @RequestMapping(value = "/bookmarks/ets1/duringThePeriod", method = RequestMethod.DELETE)
    public void deleteETS1BookmarksDuringThePeriod(@RequestParam("first") String first,
                                                   @RequestParam("last") String last
    ) throws Exception {
        ets1BookmarksService.deleteBookmarksDuringThePeriod(new DateTime(first), new DateTime(last));
    }

    @RequestMapping(value = "/bookmarks/ets1/byDate/{date}", method = RequestMethod.DELETE)
    public void deleteETS1BookmarksByDate(@PathVariable("date") String date) throws Exception {
        ets1BookmarksService.deleteBookmarksDuringThePeriod(new DateTime(date));
    }
}
