package gogitek.restaurantorder.controller.admincontroller;

import gogitek.restaurantorder.constaint.FormatPrice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class MainAdminController {
    private final FormatPrice formatPrice;


    @ModelAttribute
    public void getTopOrder(Model model) {
        model.addAttribute("format", formatPrice);
    }
    @GetMapping("/admin")
    public String getViewMainAdmin(Model model) {
        return "admin-page/admin";
    }

//    @GetMapping("/get-chart-information")
//    @ResponseBody
//    public ChartDTO handleChartInformation() {
//        return adminService.getInformationForChart();
//    }
//    @GetMapping("/getFillChartInformation/{fromdate}/{todate}")
//    @ResponseBody
//    public ChartDTO handleChartFillterInformation(@PathVariable("fromdate") String fromdate,
//                                                  @PathVariable("todate") String todate) throws ParseException {
//        ChartDTO chartDTO = new ChartDTO();
//        System.out.println(fromdate);
//        System.out.println(todate);
//        Date start =new SimpleDateFormat("yyyy-dd-MM").parse(fromdate);
//        Date end =new SimpleDateFormat("yyyy-dd-MM").parse(todate);
//        chartDTO.setRevenue(adminService.getTotalPriceByDate(start, end));
//        chartDTO.setCost(adminService.getImportPriceByDate(start,end));
//        System.out.println(chartDTO.getCost());
//        System.out.println(chartDTO.getRevenue());
//        return chartDTO;
//    }
}
