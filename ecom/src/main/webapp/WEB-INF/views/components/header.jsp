<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

 <header>
    <div class="header-container">
      <div class="header-top">
        <div class="container">
          <div class="row"> 
            <!-- Header Language -->
            <div class="col-xs-7 col-sm-6">
              <div class="dropdown block-language-wrapper hidden-xs"> <a role="button" data-toggle="dropdown" data-target="#" class="block-language dropdown-toggle" href="#"> <img src="static/images/english.png" alt="language"> English <span class="caret"></span> </a>
                <ul class="dropdown-menu" role="menu">
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#"><img src="static/images/english.png" alt="language"> English </a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#"><img src="static/images/francais.png" alt="language"> French </a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#"><img src="static/images/german.png" alt="language"> German </a></li>
                </ul>
              </div>
              <!-- End Header Language --> 
              
              <!-- Header Currency -->
              <div class="dropdown block-currency-wrapper hidden-xs"> <a role="button" data-toggle="dropdown" data-target="#" class="block-currency dropdown-toggle" href="#"> USD <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#"> Dollar </a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#"> Pound </a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#"> Euro </a></li>
                </ul>
              </div>
              <!-- End Header Currency -->
              
              <!-- <div class="welcome-msg hidden-xs"> Default welcome msg! </div> -->
            </div>
            <div class="col-xs-5 col-sm-6"> 
              
              
            <div id="ajaxconfig_info" style="display:none"><a href="#/"></a>
              <input value="" type="hidden">
              <input id="enable_module" value="1" type="hidden">
              <input class="effect_to_cart" value="1" type="hidden">
              <input class="title_shopping_cart" value="Go to shopping cart" type="hidden">
            </div>
          </div>
          
          <div class="top-search">
            <div class="block-icon pull-right"> <a data-target=".bs-example-modal-lg" data-toggle="modal" class="search-focus dropdown-toggle links"> <i class="fa fa-search"></i> </a>
              <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button aria-label="Close" data-dismiss="modal" class="close" type="button"><img src="static/images/interstitial-close.png" alt="close"> </button>
                    </div>
                    <div class="modal-body">
                      <form class="navbar-form" action="search" method="post">
                        <div id="search">
                          <div class="input-group">
                            <input name="keyword" placeholder="Search" class="form-control" type="text">
                            <button type="submit" class="btn-search"><i class="fa fa-search"></i></button>
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
            
            
              <!-- Header Top Links -->
              <div class="toplinks">
                <div class="links">
                
                  <c:choose>
            <c:when test="${empty loggedInuser}">
              <div class="login"><a href="login"><span class="hidden-xs">Log In</span></a></div>
              <div class="login"><a href="signup"><span class="hidden-xs">Register</span></a></div>
            </c:when>
            <c:otherwise>
            <c:if test="${fn:contains(role, 'ADMIN')}">
            <%-- <c:if test="${role eq 'ADMIN' || role eq 'DBA'}"> --%>
              <div class="login"><a href="admin"><span class="hidden-xs">admin</span></a></div>
              <div class="login"><a href="addeq"><span class="hidden-xs">Equation</span></a></div>
            </c:if>
              <div class="myaccount"><a title="My Account" href="profile"><span class="hidden-xs">My Account</span></a></div>
              <div class="myaccount"><a title="My Account" href="logout"><span class="hidden-xs">Logout</span></a></div>
            </c:otherwise>
            </c:choose>
                  
                </div>
                
              </div>
              <!-- End Header Top Links --> 
              
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
  
  <nav>
    <div class="container">
          <!-- Header Logo -->
          <div class="logo"><a title="Datson" href="home"><img alt="Datson" src="static/images/logo.png"></a></div>
          <!-- End Header Logo --> 

        <div class="mm-toggle-wrap">
          <div class="mm-toggle"><i class="fa fa-reorder"></i><span class="mm-label">Menu</span> </div>
        </div>
     
          <ul class="nav hidden-xs menu-item menu-item-left">
            <li class="level0 parent drop-menu active"><a href="home"><span>Home</span></a></li>
            <li class="mega-menu"><a class="level-top" href="about"><span>About</span></a></li>
            <li class="level0 nav-8 level-top"><a href="contact" class="level-top"><span>Contact</span></a></li>
            </ul>
            <ul class="nav hidden-xs menu-item menu-item-right">
            <li class="mega-menu ${math}"><a class="level-top" href="math"><span>Math</span></a></li>
            
          </ul>
      </div>
  </nav>
</body>
</html>