package one.servises.managers.paginationManager;


import one.persistence.data.IReport;
import one.persistence.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaginationManager {
    private Integer sessionSize;
    private Integer sessionPage;
    private Pageable pageable;
    private String requestSize;
    private String requestPage;

    private Integer resultPage;
    private Integer resultSize;
    private Page<Report> page;
    private List<Integer> buttons;

    @Autowired
    private IReport iReport;
    private final int INITIAL_SIZE = 5;
    private final int INITIAL_PAGE = 0;


    public PaginationManager() {
    }

    /**
     * Defines data for pagination.
     *
     * @param reportData defines certain conference list for pagination, can take values: "future", "past", "offered".
     */
    public void pagination(String reportData) {
        if (requestSize != null) {
            resultSize = Integer.parseInt(requestSize);
            resultPage = sessionPage != null ? (int) (Math.ceil(sessionSize * sessionPage) / Double.parseDouble(requestSize)) : INITIAL_PAGE;
        } else if (requestPage != null) {
            resultPage = Integer.parseInt(requestPage);
            resultSize = sessionSize != null ? sessionSize : INITIAL_SIZE;
        } else if (sessionPage != null) {
            resultPage = sessionPage;
            resultSize = sessionSize != null ? sessionSize : INITIAL_SIZE;
        } else {
            resultPage = INITIAL_PAGE;
            resultSize = sessionSize != null ? sessionSize : INITIAL_SIZE;
        }
        pageable = PageRequest.of(resultPage, resultSize);
        page = selectConference(reportData, pageable);
        buttons = buttons(page);

        if (page.isEmpty() && page.getTotalPages() > 0) {
            resultPage -= 1;
            pageable = PageRequest.of(resultPage, resultSize);
            page = selectConference(reportData, pageable);
            buttons = buttons(page);
        }
    }

    private List<Integer> buttons(Page<Report> pages) {
        int countOfPages = pages.getTotalPages();
        List<Integer> buttons = new ArrayList<>();
        for (int i = 1; i <= countOfPages; i++) {
            buttons.add(i);
        }
        return buttons;
    }

    private Page<Report> selectConference(String report, Pageable pageable) {
        Page<Report> page;
        if (report.equals("future")) {
            page = iReport.futureReports(new Date(), pageable);
        } else if (report.equals("past")) {
            page = iReport.pastReports(new Date(), pageable);
        } else {
            page = iReport.offeredReports(pageable);
        }
        return page;
    }

    public void setSessionSize(Integer sessionSize) {
        this.sessionSize = sessionSize;
    }

    public void setSessionPage(Integer sessionPage) {
        this.sessionPage = sessionPage;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public void setRequestSize(String requestSize) {
        this.requestSize = requestSize;
    }

    public void setRequestPage(String requestPage) {
        this.requestPage = requestPage;
    }

    public Integer getResultPage() {
        return resultPage;
    }

    public Integer getResultSize() {
        return resultSize;
    }

    public Page<Report> getPage() {
        return page;
    }

    public List<Integer> getButtons() {
        return buttons;
    }
}
