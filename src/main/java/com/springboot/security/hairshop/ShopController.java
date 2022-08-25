package com.springboot.security.hairshop;

import com.springboot.security.config.BaseException;
import com.springboot.security.config.BaseResponse;
import com.springboot.security.hairshop.model.GetShopRes;
import com.springboot.security.review.ReviewProvider;
import com.springboot.security.review.ReviewService;
import com.springboot.security.user.model.GetUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private final ShopProvider shopProvider;
    @Autowired
    private final ShopService shopService;

    public ShopController(ShopProvider shopProvider, ShopService shopService){
        this.shopProvider = shopProvider;
        this.shopService = shopService;
    }

    //헤어샵 이름으로 검색 시 이름 포함된 헤어샵 리스트로 출력
    @GetMapping("/searchShopNames")
    public  List<GetShopRes> getShops(@RequestParam("shopName")String shopName) {

        List<GetShopRes> shopRes = shopProvider.getShop(shopName);

        return shopRes;
    }

    //리스트 중 하나 눌렀을 때 선택 된 헤어샵 id 정보
    @GetMapping("/searchShopNames/{shopId}")
    public String getOneShop(@PathVariable("shopId") int shopId, HttpSession session){
        GetShopRes oneShopRes=shopProvider.getOneShop(shopId);
        session.setAttribute("searchShopId",new Integer( oneShopRes.getShop_id()));

        return oneShopRes.getShop_name();

    }

}
