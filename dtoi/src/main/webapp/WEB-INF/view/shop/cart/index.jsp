<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.*" %>
<%@ page import="customer.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>DtoI</title>
<%@ include file="/WEB-INF/view/include/userHeadHtml.jsp" %>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
 <%@ include file="/WEB-INF/view/include/header.jsp" %>
    
<div class="sub">
	<div class="size">
		<h3 class="sub_title">장바구니</h3>
	
			<div class="bbs"> 
				<div class="area_top">
				
					<div class="check_all">
						<input type="checkbox" id="allCheck" onclick="cartIdxs">
						<label for="allCheck" style="cursor: pointer;">전체선택</label>
					</div>
				
					<table class="tbl_col prd">
					<caption class="hidden">장바구니</caption>
					<colgroup>
						<col style="width:110px;">
						<col>
						<col style="width:142px;">
						<col style="width:56px;">
					</colgroup>
					<thead>
						<tr>
							<th scope="col" colspan="2">상품</th>
							<th scope="col">가격</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="img">
								<a href="/dtoi/product/detail.do?${vo.pd_no }" target="_blank" >
								<img src="/dtoi/upload/${vo.pd_image }" alt=""/>
								</a>
							</td>
							<td class="tal">
								<form class="goods-form">

									<div class="check">
									<input type="checkbox" value="28484990" class="cartIdxs">
									</div>
									<div class="name">
										<a href="/dtoi/product/detail.do?${vo.pd_no }" target="_blank"> ${vo.pd_no }</a>
									</div>
									<div class="qty">
										<a href="javascript:" onclick="ct_countFunc('minus');" ><img src="/dtoi/img/product/cart/count_down.png"></a>
										<input type="text" name="ct_count" id="ct_count" readonly value="1">
										<a href="javascript:" onclick="ct_countFunc('plus');" ><img src="/dtoi/img/product/cart/count_up.png"></a>
									</div>
								</form>
							</td>
							<td class="qty">
								<strong id="total_price" style=padding:20px;> ${vo.pd_price }</strong>원 &nbsp;
							</td>
							<td class="qty">
							<a href="javascript:" onclick="ct_countFunc('del');" ><img src="/dtoi/img/product/cart/count_del.png"></a>
							</td>						
						</tr>
					</tbody>
					</table>
					
				<ul class="cart_btn">
					<li class="box_btn">
					<a href="javascript:" onclick="choose_buy();">선택상품 주문</a>
					</li>
					<li class="box_btn">
					<a href="javascript:" onclick="choose_del();">선택상품 삭제</a>
					</li>
					<li class="box_btn">
					<a href="javascript:" onclick="cart_all_del()();">장바구니 비우기</a>
					</li>
				</ul>
			</div>
			<!-- area_top -->
			
			<div class="area_bottom">
					<div class="orderCart__total__calc">
						<span class="calc__total"> 총 상품금액 <span class="price">12,000원</span></span>
						<span class="calc__deli">+ 배송비 <span class="price">3000 원</span></span>
					</div>

					<div class="orderCart__total__cont">
						<p class="orderCart__total__txt">총 결제 예정금액</p>
						<em class="orderCart__total__price"><span>0</span>원</em>
					</div>

			</div>
			
			

			<div class="pagenate clear">
			</div>
		</div>
		<!-- bbs -->
	</div>
</div>
   <%@ include file="/WEB-INF/view/include/footer.jsp" %>
     
</body>
</html>