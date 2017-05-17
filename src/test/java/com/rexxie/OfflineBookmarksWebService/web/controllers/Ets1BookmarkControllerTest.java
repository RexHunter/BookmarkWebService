package com.rexxie.OfflineBookmarksWebService.web.controllers;

import com.rexxie.OfflineBookmarksWebService.db.modules.ets1.services.Ets1BookmarksService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class Ets1BookmarkControllerTest extends APITest {

    @MockBean
    private Ets1BookmarksService ets1BookmarksService;

    @Before
    public void before() {

    }

    @Test
    public void getETS1BookmarksDuringThePeriod() throws Exception {

        this.mockMvc.perform(
                get("/bookmarks/ets1/duringThePeriod")
                        .requestAttr("first", "2017-03-01")
                        .requestAttr("last", "2017-03-01")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }




//    @RequestMapping(value = "/bookmarks/ets1/duringThePeriod", method = RequestMethod.GET)
//    public List<Bookmark> getETS1BookmarksDuringThePeriod(@RequestParam("first") String first,
//                                                          @RequestParam("last") String last,
//                                                          @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
//                                                          @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
//    ) throws Exception {
//        return ets1BookmarksService.getBookmarksDuringThePeriod(new DateTime(first), new DateTime(last), limit, offset);
//    }
//
//    @RequestMapping(value = "/bookmarks/ets1/lastFewDays/{days}", method = RequestMethod.GET)
//    public List<Bookmark> getETS1BookmarksByLastFewDays(@PathVariable("days") Integer days,
//                                                          @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
//                                                          @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
//    ) throws Exception {
//        return ets1BookmarksService.getBookmarksByLastFewDays(days, limit, offset);
//    }
//
//    @RequestMapping(value = "/bookmarks/ets1/byDate/{date}", method = RequestMethod.GET)
//    public List<Bookmark> getETS1BookmarksByDate(@PathVariable("date") String date,
//                                                          @RequestParam(name = "limit", defaultValue = "1000", required = false) Integer limit,
//                                                          @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
//    ) throws Exception {
//        return ets1BookmarksService.getBookmarksByDate(new DateTime(date), limit, offset);
//    }

}
