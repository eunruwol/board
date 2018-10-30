$(document).ready(function(){
	/***************************************************************
		Page Entering Animation
	***************************************************************/

		function pageEnterAnimation() {
			// Contact Page
			if ( $(".contact").length ) {
				$("#contactEffect").addClass("reveal");
				setTimeout(function(){
					$(".contact-box").addClass("reveal");
					setTimeout(function(){
						$(".contact-map").addClass("reveal");
					}, 300);
				}, 150);
			}

			// Coworking Page
			if ( $(".coworking").length ) {
				$(".page-opening-box").removeClass("unreveal");
				setTimeout(function(){
					$(".page-opening-box-content").removeClass("hide");
					setTimeout(function(){
						$(".page-opening-box-benefits").removeClass("hide");
						setTimeout(function(){
							$(".page-opening-video-text").addClass("reveal");
						}, 80);
					}, 80);
				}, 700);
			}

			// Coffee Page
			if ( $(".coffee").length ) {
				$(".page-opening-box").removeClass("unreveal");
				setTimeout(function(){
					$(".page-opening-box-content").removeClass("hide");
					setTimeout(function(){
						$(".page-opening-box-benefits").removeClass("hide");
						setTimeout(function(){
							$(".page-opening-video-text").addClass("reveal");
						}, 80);
					}, 80);
				}, 700);
			}

			// Events Page
			if ( $(".events").length ) {
				$(".events-past").addClass("reveal");

				setTimeout(function(){
					$(".events-upcoming h1").addClass("reveal");
					$(".events-past-scroll h2").addClass("reveal");

					setTimeout(function(){
						var upcomingEvents = $(".events-upcoming-list-item").length;
						$(".events-upcoming-list-item").each(function(index){
							if ( index < 3 ) {
								var that = $(this);
								setTimeout(function(){
									that.addClass("reveal");
								}, ((index+1) * 100));
							}
						});
						if ( upcomingEvents > 3 ) {
							setTimeout(function(){
								$(".events-upcoming-morebutton").fadeIn();
							}, (300+800));
						}

						$(".events-past-list a").each(function(index){
							var that = $(this);
							setTimeout(function(){
								that.addClass("reveal");
							}, ((index+1) * 100));
						});
					}, 100);

				}, 500);
			}
		}



	/***************************************************************
		Menu Open/Close
	***************************************************************/

		var menuCanChange = true;
		$(".hamburger").on("click", function(){
			if ( menuCanChange ) {
				menuCanChange = false;
				if ( !$(this).hasClass("active") ) {

					$(this).addClass("active");
					$(".menu-wrapper").toggleClass("active");
					setTimeout(function(){
						$(".menu-wrapper-logo").addClass("active");
						$(".main-navigation ul li").each(function(index){
							var that = $(this);
							setTimeout(function(){
								that.addClass("enter");
							}, (80*index));
						});
						setTimeout(function(){
							menuCanChange = true;
						}, 500);
					}, 500);

				} else {

					var that = $(this);

					$(".menu-wrapper-logo").removeClass("active");
					$(".main-navigation ul li").removeClass("enter");
					setTimeout(function(){
						$(".menu-wrapper").addClass("close");
						that.removeClass("active");
						setTimeout(function(){
							$(".menu-wrapper").removeClass("active close");
							menuCanChange = true;
						}, 300);
					}, 150);

				}
			}
		});



	/***************************************************************
		Intro - Choose Page
	***************************************************************/


		var introFlag = false;
		
		if ( $(".opening-content-nav-thumb").length ) {
			// Mobile
			$(".opening-content-nav-thumb")[0].addEventListener("touchstart", handleTouchStart, false);
			$(".opening-content-nav-thumb")[0].addEventListener("touchend", handleTouchEnd, false);
			$(".opening-content-nav-thumb")[0].addEventListener("touchmove", handleTouchMove, false);

			function handleTouchStart() {
				introFlag = true;
			}

			function handleTouchMove(event) {
				if ( introFlag ) {
					var xPlace = event.changedTouches[0].pageX;
					var mockupWidth = $(".opening-content-nav-track-wrapper").width();
					var mockupLeft = $(".opening-content-nav-track-wrapper").offset().left;

					var fromLeft = (xPlace-mockupLeft)/mockupWidth*100;
					
					if ( fromLeft > 100 ) {
						var fromLeftCSS = "100%";
					} else if ( fromLeft < 0 ) {
						var fromLeftCSS = "0%";
					} else {
						var fromLeftCSS = fromLeft + "%";
					}

					$(".opening-content-nav-thumb").css("left", fromLeftCSS);

					if ( fromLeft < 50 ) {
						var opacityCSS = ( fromLeft * 2 ) / 100;
						$(".opening-preview-coworking").css("z-index", "1");
						$(".opening-preview-coffee").css("z-index", "2");
						$(".opening-video").css("opacity", opacityCSS);
					} else {
						var opacityCSS = ( ( 100 - fromLeft ) * 2 ) / 100;
						$(".opening-preview-coffee").css("z-index", "1");
						$(".opening-preview-coworking").css("z-index", "2");
						$(".opening-video").css("opacity", opacityCSS);
					}

					if ( fromLeft > 85 ) {
						getPointerBackFlag = false;
						moveToPage("coworking");
					} else if ( fromLeft < 15 ) {
						getPointerBackFlag = false;
						moveToPage("coffee");
					}
				}
			}

			function handleTouchEnd() {
				introFlag = false;
				getPointerToPoint();
			}


			// Desktop
			$(".opening-content-nav-thumb").on("mousedown", function(){
				introFlag = true;
			}).mouseup(function(){
				introFlag = false;
				getPointerToPoint();
			});
			
			$(document).on("mouseup", function(){
				introFlag = false;
				getPointerToPoint();
			});
			
			$(".opening-content-nav-track-wrapper").on("mousemove", function(event){
				if ( introFlag ) {
					var xPlace = event.pageX;
					var mockupWidth = $(".opening-content-nav-track-wrapper").width();
					var mockupLeft = $(".opening-content-nav-track-wrapper").offset().left;

					var fromLeft = (xPlace-mockupLeft)/mockupWidth*100;
					
					if ( fromLeft > 100 ) {
						var fromLeftCSS = "100%";
					} else if ( fromLeft < 0 ) {
						var fromLeftCSS = "0%";
					} else {
						var fromLeftCSS = fromLeft + "%";
					}

					$(".opening-content-nav-thumb").css("left", fromLeftCSS);

					if ( fromLeft < 50 ) {
						var opacityCSS = ( fromLeft * 2 ) / 100;
						$(".opening-preview-coworking").css("z-index", "1");
						$(".opening-preview-coffee").css("z-index", "2");
						$(".opening-video").css("opacity", opacityCSS);
					} else {
						var opacityCSS = ( ( 100 - fromLeft ) * 2 ) / 100;
						$(".opening-preview-coffee").css("z-index", "1");
						$(".opening-preview-coworking").css("z-index", "2");
						$(".opening-video").css("opacity", opacityCSS);
					}

					if ( fromLeft > 90 ) {
						getPointerBackFlag = false;
						moveToPage("coworking");
					} else if ( fromLeft < 10 ) {
						getPointerBackFlag = false;
						moveToPage("coffee");
					}
				}
			});

			getPointerBackFlag = true;
			function getPointerToPoint() {
				if ( getPointerBackFlag ) {
					$(".opening-content-nav-track").addClass("goBack");
					$(".opening-video").addClass("goBack");
					$(".opening-content-nav-thumb").css("left", "50%");
					$(".opening-video").css("opacity", "1");
					setTimeout(function(){
						$(".opening-content-nav-track").removeClass("goBack");
						$(".opening-video").removeClass("goBack");
					}, 500);
				}
			}

			function moveToPage(page) {
					introFlag = false;
				if ( page == "coworking" ) {
					$(".opening-content-nav-track").addClass("goBack");
					setTimeout(function(){
						$(".opening-content-nav-thumb").addClass("moveToRight");
						setTimeout(function(){
							$(".opening-content-nav-thumb").addClass("end");
						}, 300);
					}, 50);

					$(".opening-preview-coworking").css("z-index", "2");
					$(".opening-preview-coffee").css("z-index", "1");
					var redirectURL = $(".opening-preview-coworking").data("link");

				} else {
					$(".opening-content-nav-track").addClass("goBack");
					setTimeout(function(){
						$(".opening-content-nav-thumb").addClass("moveToLeft");
						setTimeout(function(){
							$(".opening-content-nav-thumb").addClass("end");
						}, 300);
					}, 50);

					$(".opening-preview-coworking").css("z-index", "1");
					$(".opening-preview-coffee").css("z-index", "2");
					var redirectURL = $(".opening-preview-coffee").data("link");
				}

				setTimeout(function(){
					$(".opening-video, .opening-content").fadeOut(400, function(){
							window.location = redirectURL;
					});
				}, 400);
			}
		}



	/***************************************************************
		Inputs Handler
	***************************************************************/

		$(".input-wrapper input").focusout(function(){
			if ( $(this).val() == "" ) {
				$(this).parents(".input-wrapper").removeClass("active");
			} else {
				$(this).parents(".input-wrapper").addClass("active");
			}
		});



	/***************************************************************
		Music On/Off + Hover
	***************************************************************/


		if ( $(".home").length ) {
			$(".music").removeClass("active");
			setTimeout(function(){
				$(".music").addClass("active");
			}, 2000);
		}

		$(".music-icon").on("click", function(){
			if ( $(this).parents(".music").hasClass("on") ) {
				$(".music audio")[0].pause();
				$(this).parents(".music").removeClass("on");
				$(this).parents(".music").addClass("off");
				setCookie("music", "false", "365");
			} else {
				$(".music audio")[0].play();
				$(this).parents(".music").removeClass("off");
				$(this).parents(".music").addClass("on");
				setCookie("music", "true", "365");
			}
		});

		$(".music-icon").hover(function(){
			if ( $(this).parents(".music").hasClass("active") ) {
				$(this).parents(".music").removeClass("active");
			}
		}, function(){
			setTimeout(function(){
				$(".music").addClass("active");
			}, 500);
		});


		function setCookie(name, value, days) {
			var expires = "";
			if (days) {
				var date = new Date();
				date.setTime(date.getTime() + (days*24*60*60*1000));
				expires = "; expires=" + date.toUTCString();
			}
			document.cookie = name + "=" + (value || "")  + expires + "; path=/";
		}



	/***************************************************************
		GoToBenefits Button
	***************************************************************/

		$("#goToBenefits").on("click", function(){
			scrollingNow = true;
			scrollDownCoworking();
		});


	/***************************************************************
		Benefits Hover
	***************************************************************/

		var benefitsHighestZIndex = 1;
		$(".benefits-item").hover(function(){
			benefitsHighestZIndex++;
			$(this).css("z-index", benefitsHighestZIndex);
		});



	/***************************************************************
		Services Hover Effect
	***************************************************************/

		$(".services-links-item").hover(function(){
			if ( window.innerWidth >= 1300 ) {
				if ( !scrollingNow ) {
					$(this).addClass("active");
					var itemIndex = $(this).index() + 1;
					var backgroundImage = $(".services-background-divided div:nth-of-type(" + itemIndex + ") div").css("background-image");
					$(".services-background-divided").hide();
					$(".services-background-big div").css("background-image", backgroundImage);
					$(".services-background").addClass("active");
				}
			}
		}, function(){
			if ( window.innerWidth >= 1300 ) {
				if ( !scrollingNow ) {
					$(this).removeClass("active");
					$(".services-background-divided").show();
					$(".services-background-big div").css("background-image", "");
					$(".services-background").removeClass("active");
				}
			}
		});



	/***************************************************************
		Gallery Hover
	***************************************************************/

		var galleryHighestZIndex = 1;
		$(".page-gallery-item").hover(function(){
			galleryHighestZIndex++;
			$(this).css("z-index", galleryHighestZIndex);
		});



	/***************************************************************
		Workers Choose
	***************************************************************/

		$(".form-workers input[type='radio']").change(function(){
			$(".form-workers").addClass("active");
		});



	/***************************************************************
		Gallery Slider
	***************************************************************/

		if ( $(".page-gallery").length ) {
			$(".page-gallery-slider").slick({
				rtl: true,
				dots: true,
				arrows: true,
				slidesToShow: 1,
				slidesToScroll: 1,
				fade: true,
				speed: 1000,
				swipe: true,
				pauseOnHover: false,
				pauseOnFocus: false,
				prevArrow: '<button type="button" class="slick-arrow slick-prev"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 252.15 477.17"><path class="a" d="M332,238.6,116.49,454.1a13.51,13.51,0,0,0,19.1,19.1l225.1-225.1a13.46,13.46,0,0,0,0-19.1L135.59,4a13.59,13.59,0,0,0-9.5-4,13.17,13.17,0,0,0-9.5,4,13.46,13.46,0,0,0,0,19.1Z" transform="translate(-112.51 0)"/></svg></button>',
				nextArrow: '<button type="button" class="slick-arrow slick-next"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 252.15 477.17"><path class="a" d="M145.19,238.57l215.5-215.5A13.51,13.51,0,1,0,341.59,4l-225.1,225.1a13.46,13.46,0,0,0,0,19.1l225.1,225a13.59,13.59,0,0,0,9.5,4,13.17,13.17,0,0,0,9.5-4,13.46,13.46,0,0,0,0-19.1Z" transform="translate(-112.51 0)"/></svg></button>'
			});

			var numberOfSlides = $(".page-gallery-slider .slick-dots li").length;
			var dotsFrom = "<span> ׳׳×׳•׳ " + numberOfSlides + "</span>";

			$(".page-gallery-slider .slick-prev").prependTo(".page-gallery-slider .slick-dots");
			$(dotsFrom).appendTo(".page-gallery-slider .slick-dots");
			$(".page-gallery-slider .slick-next").appendTo(".page-gallery-slider .slick-dots");
		}



	/***************************************************************
		Coworking Page Effects
	***************************************************************/

		if ( $(".contact-map-place").length ) {
			$(".contact-map-place").each(function(){
				new_map($(this));
			});
		}



	/***************************************************************
		Past Events
	***************************************************************/

		$("#openEventsPast").on("click", function(){
			$(".events-past").addClass("open");
			$(".header-accessibility, .credits").removeClass("dark");
		});

		$("#closeEventsPast").on("click", function(){
			$(".events-past").removeClass("open");
			$(".header-accessibility, .credits").addClass("dark");
		});



	/***************************************************************
		Events Form
	***************************************************************/

		$(".openEventForm").on("click", function(){
			$(".eventpopup").fadeIn();
			$("input[name='event']").val( $(this).data("title") );
		});

		$("#closeEventPopup").on("click", function(){
			$(".eventpopup").fadeOut();
		});



	/***************************************************************
		Coworking Page Effects - Scroll
	***************************************************************/

		var scrollingNow = false;
		var currentSection = 1;

		document.addEventListener('wheel', function(e) {
			if ( window.innerWidth >= 1300 ) {
				if ( $(".coworking").length ) {
					if ( !scrollingNow ) {
						scrollingNow = true;
						if ( e.deltaY > 0 ) {
							if ( currentSection == 5 ) {
								scrollingNow = false;
							} else {
								scrollDownCoworking();
							}
						} else {
							if ( currentSection == 1 ) {
								scrollingNow = false;
							} else {
								scrollUpCoworking();
							}
						}
					}
				} else if ( $(".coffee").length ) {
					if ( !scrollingNow ) {
						scrollingNow = true;
						if ( e.deltaY > 0 ) {
							if ( currentSection == 3 ) {
								scrollingNow = false;
							} else {
								scrollDownCoffee();
							}
						} else {
							if ( currentSection == 1 ) {
								scrollingNow = false;
							} else {
								scrollUpCoffee();
							}
						}
					}
				}
			}
		});

		function scrollDownCoworking() {
			switch ( currentSection ) {
				// 1 To 2
				case 1:
					$(".page-opening-box-content, .page-opening-box-benefits").addClass("hide");

					setTimeout(function(){
						$(".page-opening-video-text").removeClass("reveal");

						setTimeout(function(){
							$(".page-opening-box").addClass("expand");

							setTimeout(function(){
								$(".header-accessibility, .credits").addClass("dark");
							}, 500);

							setTimeout(function(){
								$(".page-opening").css("z-index", "1").hide();
								$(".benefits").css("z-index", "2").show();
								$("#benefitsEffect").show();

								setTimeout(function(){
									var benefitsWidth = $(".benefits-box").outerWidth();
									var benefitsHeight = $(".benefits-box").outerHeight();
									$("#benefitsEffect").css({
										"width": benefitsWidth,
										"height": benefitsHeight
									});

									setTimeout(function(){
										$("#benefitsEffect").hide();
										$(".benefits-box").show();
										setTimeout(function(){
											$(".benefits-content").addClass("reveal");
											setTimeout(function(){
												$(".benefits-list").addClass("reveal");
												
												setTimeout(function(){
													scrollingNow = false;
													currentSection++;
												}, 300);

											}, 80);
										}, 10);
									}, 200);

								}, 200);

							}, 700);

						}, 200);

					}, 80);
				break;

				// 2 To 3
				case 2:
					$(".benefits-content, .benefits-list").removeClass("reveal");

					setTimeout(function(){
						$("#benefitsEffect").show();
						$(".benefits-box").hide();

						setTimeout(function(){
							$("#benefitsEffect").css({
								"width": "100%",
								"height": "100%"
							});

							setTimeout(function(){
								$(".headerlogo, .header-accessibility, .social, .music, .credits").removeClass("dark");

								$(".benefits").css("z-index", "1").hide();
								$(".services").css("z-index", "2").show();
								
								setTimeout(function(){
									$(".services-background-divided").addClass("reveal");
									
									setTimeout(function(){
										$(".services-background-big").show();
										$(".services-links").addClass("reveal");
										
										setTimeout(function(){
											scrollingNow = false;
											currentSection++;
										}, 400);

									}, 400);

								}, 30);

							}, 200);

						}, 50);

					}, 300);
				break;


				// 3 To 4
				case 3:
					$(".page-frame").addClass("active");

					$(".headerlogo, .header-accessibility, .social, .music, .credits").addClass("dark");

					setTimeout(function(){
						$("#galleryEffect").addClass("reveal");

						setTimeout(function(){
							$(".services").css("z-index", "1").hide();
							$(".page-gallery").css("z-index", "2").show();
							$(".page-gallery-slider").slick("setPosition");
							
							setTimeout(function(){
								$("#galleryEffect").addClass("reverse");
								$("#galleryEffect").removeClass("reveal");
								$(".page-frame").removeClass("active");
								
								setTimeout(function(){
									scrollingNow = false;
									currentSection++;
								}, 500);

							}, 10);

						}, 500);

					}, 300);
				break;


				// 4 To 5
				case 4:
					$(".page-gallery").addClass("active");

					$(".headerlogo, .music, .credits").removeClass("dark");

					setTimeout(function(){
						scrollingNow = false;
						currentSection++;
					}, 300);
				break;
			}
		}

		function scrollUpCoworking() {
			switch ( currentSection ) {
				// 2 To 1
				case 2:
					$(".benefits-content, .benefits-list").removeClass("reveal");

					setTimeout(function(){
						$("#benefitsEffect").show();
						$(".benefits-box").hide();
						
						setTimeout(function(){
							$("#benefitsEffect").css({
								"width": "100%",
								"height": "100%"
							});

							setTimeout(function(){
								$(".benefits").css("z-index", "1").hide();
								$(".page-opening").css("z-index", "2").show();
								$("#benefitsEffect").hide();
								
								setTimeout(function(){
									$(".page-opening-box").removeClass("expand");

									setTimeout(function(){
										$(".header-accessibility, .credits").removeClass("dark");
									}, 200);

									setTimeout(function(){
										$(".page-opening-box-content").removeClass("hide");
										
										setTimeout(function(){
											$(".page-opening-box-benefits").removeClass("hide");

											setTimeout(function(){
												$(".page-opening-video-text").addClass("reveal");

												setTimeout(function(){
													scrollingNow = false;
													currentSection--;
												}, 500);

											}, 80);

										}, 80);

									}, 650);
								
								}, 50);

							}, 150);

						}, 100);
					
					}, 300);
				break;

				
				// 3 To 2
				case 3:
					$(".services-background-big").hide();
					$(".services-links-item").removeClass("active");
					$(".services-background-divided").show();
					$(".services-background-big div").css("background-image", "");
					$(".services-background").removeClass("active");

					$(".services-links").removeClass("reveal");

					setTimeout(function(){
						$(".services-background-divided").removeClass("reveal");

					$(".headerlogo, .header-accessibility, .social, .music, .credits").addClass("dark");
						
						setTimeout(function(){
							$(".services").css("z-index", "1").hide();
							$(".benefits").css("z-index", "2").show();

							setTimeout(function(){
								var benefitsWidth = $(".benefits-box").outerWidth();
								var benefitsHeight = $(".benefits-box").outerHeight();
								$("#benefitsEffect").css({
									"width": benefitsWidth,
									"height": benefitsHeight
								});

								setTimeout(function(){
									$("#benefitsEffect").hide();
									$(".benefits-box").show();

									setTimeout(function(){
										$(".benefits-content, .benefits-list").addClass("reveal");

										setTimeout(function(){
											scrollingNow = false;
											currentSection--;
										}, 300);

									}, 50);

								}, 200);

							}, 50);

						}, 400);

					}, 400);
				break;


				// 4 To 3
				case 4:
					$("#galleryEffect").removeClass("reverse");
					$("#galleryEffect").addClass("reveal");

					setTimeout(function(){
						$(".page-gallery").css("z-index", "1").hide();
						$(".services").css("z-index", "2").show();

						$("#galleryEffect").addClass("reverse");
						$("#galleryEffect").removeClass("reveal");

						$(".headerlogo, .header-accessibility, .social, .music, .credits").removeClass("dark");

						setTimeout(function(){
							$("#galleryEffect").removeClass("reverse");
							scrollingNow = false;
							currentSection--;
						}, 500);

					}, 500);

				break;

				
				// 5 To 4
				case 5:
					$(".page-gallery").removeClass("active");

					$(".headerlogo, .music, .credits").addClass("dark");

					setTimeout(function(){
						scrollingNow = false;
						currentSection--;
					}, 300);
				break;
			}
		}










		function scrollDownCoffee() {
			switch ( currentSection ) {
				// 1 To 2
				case 1:
					$(".page-opening-box-content, .page-opening-box-benefits").addClass("hide");

					setTimeout(function(){
						$(".page-opening-video-text").removeClass("reveal");

						setTimeout(function(){
							$(".page-opening-box").addClass("expand");

							setTimeout(function(){
								$(".header-accessibility, .credits").addClass("dark");
							}, 500);

							setTimeout(function(){
								$("#galleryEffect").addClass("reveal");

								setTimeout(function(){
									$(".page-opening").css("z-index", "1").hide();
									$(".page-gallery").css("z-index", "2").show();
									$(".page-gallery-slider").slick("setPosition");

									$("#galleryEffect").addClass("reverse");
									$("#galleryEffect").removeClass("reveal");

									setTimeout(function(){
										scrollingNow = false;
										currentSection++;
									}, 500);

								}, 500);

							}, 300);

						}, 200);

					}, 80);
				break;

				// 2 To 3
				case 2:
					$(".page-gallery").addClass("active");

					$(".headerlogo, .music, .credits").removeClass("dark");

					setTimeout(function(){
						scrollingNow = false;
						currentSection++;
					}, 300);
				break;
			}
		}

		function scrollUpCoffee() {
			switch ( currentSection ) {
				// 2 To 1
				case 2:
					$("#galleryEffect").removeClass("reverse");
					$("#galleryEffect").addClass("reveal");

					setTimeout(function(){
						$(".page-gallery").css("z-index", "1").hide();
						$(".page-opening").css("z-index", "2").show();

						$("#galleryEffect").addClass("reverse");
						$("#galleryEffect").removeClass("reveal");

						setTimeout(function(){
							$(".page-opening-box").removeClass("expand");

							setTimeout(function(){
								$(".header-accessibility, .credits").removeClass("dark");
							}, 200);

							setTimeout(function(){
								$(".page-opening-box-content").removeClass("hide");
								
								setTimeout(function(){
									$(".page-opening-box-benefits").removeClass("hide");

									setTimeout(function(){
										$(".page-opening-video-text").addClass("reveal");

										setTimeout(function(){
											$("#galleryEffect").removeClass("reverse");
											scrollingNow = false;
											currentSection--;
										}, 500);

									}, 80);

								}, 80);

							}, 650);
						
						}, 250);

					}, 500);
				break;


				// 3 To 2
				case 3:
					$(".page-gallery").removeClass("active");

					$(".headerlogo, .music, .credits").addClass("dark");

					setTimeout(function(){
						scrollingNow = false;
						currentSection--;
					}, 300);
				break;
			}
		}



	/***************************************************************
		Events More Button
	***************************************************************/

		$(".events-upcoming-morebutton button").on("click", function(){
			var shownEvents = $(".events-upcoming-list-item:not(.hide)").length;
			var hideEvents = $(".events-upcoming-list-item.hide").length;

			if ( hideEvents > 3 ) {
				var loop = 3;
			} else {
				var loop = hideEvents;
				$(".events-upcoming-morebutton").fadeOut();
			}
			for (var i = 1; i <= loop; i++) {
				revealUpcomingEvent(shownEvents, i);
			}

			function revealUpcomingEvent(total, i) {
				var index = total+i;
				$(".events-upcoming-list-item:nth-of-type(" + index + ")").removeClass("hide");
				setTimeout(function(){
					$(".events-upcoming-list-item:nth-of-type(" + index + ")").addClass("reveal");
				}, (100*i));
			}
		});


	/***************************************************************
		Elements Light/Dark In Scroll
	***************************************************************/

		elementsLightDarkCheck();
		$(window).scroll( elementsLightDarkCheck );
		$(window).resize( elementsLightDarkCheck );

		function elementsLightDarkCheck() {
			// Coworking Page
			if ( $(".coworking").length ) {
				if ( window.innerWidth < 1300 ) {
					var windowScroll = $(window).scrollTop();
					var windowHeight = $(window).height();
					var openingScroll = $(".page-opening-box").offset().top;
					var benefitsScroll = $(".benefits").offset().top;
					var servicesScroll = $(".services").offset().top;
					var galleryScroll = $(".page-gallery").offset().top;
					var galleryHeight = $(".page-gallery").outerHeight();

					if ( window.innerWidth < 992 ) {
						// Logo
						if ( ( windowScroll+50 < openingScroll ) || ( windowScroll+30 > servicesScroll && windowScroll+30 < galleryScroll ) ) {
							$(".headerlogo").removeClass("dark");
						} else {
							$(".headerlogo").addClass("dark");
						}

						// Accessibility
						if ( ( windowScroll+90 > openingScroll && windowScroll+90 < servicesScroll ) || ( windowScroll+30 > benefitsScroll && windowScroll+30 < servicesScroll ) || ( windowScroll+30 > galleryScroll ) ) {
							$(".header-accessibility").addClass("dark");
						} else {
							$(".header-accessibility").removeClass("dark");
						}

						// Credits
						if ( ( windowScroll+windowHeight-30 < servicesScroll ) || ( windowScroll+windowHeight-30 > galleryScroll && windowScroll+windowHeight-30 < galleryScroll+galleryHeight ) ) {
							$(".credits").addClass("dark");
						} else {
							$(".credits").removeClass("dark");
						}

						// Social
						if ( ( windowScroll+(windowHeight/2)-30 < openingScroll ) || ( windowScroll+(windowHeight/2)-30 > servicesScroll && windowScroll+(windowHeight/2)-30 < galleryScroll ) || ( windowScroll+(windowHeight/2)-30 > galleryScroll+galleryHeight ) ) {
							$(".social").removeClass("dark");
						} else {
							$(".social").addClass("dark");
						}
					} else {
						// Logo
						if ( windowScroll+30 > servicesScroll && windowScroll+30 < galleryScroll ) {
							$(".headerlogo").removeClass("dark");
						} else {
							$(".headerlogo").addClass("dark");
						}

						// Accessibility
						if ( ( windowScroll+30 > benefitsScroll && windowScroll+30 < servicesScroll ) || ( windowScroll+30 > galleryScroll ) ) {
							$(".header-accessibility").addClass("dark");
						} else {
							$(".header-accessibility").removeClass("dark");
						}

						// Credits
						if ( ( windowScroll+windowHeight-30 > benefitsScroll && windowScroll+windowHeight-30 < servicesScroll ) || ( windowScroll+windowHeight-30 > galleryScroll && windowScroll+windowHeight-30 < galleryScroll+galleryHeight ) ) {
							$(".credits").addClass("dark");
						} else {
							$(".credits").removeClass("dark");
						}

						// Social
						if ( ( windowScroll+(windowHeight/2)-30 > servicesScroll && windowScroll+(windowHeight/2)-30 < galleryScroll ) || ( windowScroll+(windowHeight/2)-30 > galleryScroll+galleryHeight ) ) {
							$(".social").removeClass("dark");
						} else {
							$(".social").addClass("dark");
						}
					}


					// Music
					if ( ( windowScroll+windowHeight-30 > servicesScroll && windowScroll+windowHeight-30 < galleryScroll ) || ( windowScroll+windowHeight-30 > galleryScroll+galleryHeight ) ) {
						$(".music").removeClass("dark");
					} else {
						$(".music").addClass("dark");
					}
				} else {
					$(".headerlogo, .music, .social").addClass("dark");
					$(".header-accessibility, .credits").removeClass("dark");
				}

			// Coffee Page
			} else if ( $(".coffee").length ) {
				if ( window.innerWidth < 1300 ) {
					var windowScroll = $(window).scrollTop();
					var windowHeight = $(window).height();
					var openingScroll = $(".page-opening-box").offset().top;
					var galleryScroll = $(".page-gallery").offset().top;
					var galleryHeight = $(".page-gallery").outerHeight();

					if ( window.innerWidth < 992 ) {
						// Logo
						if ( windowScroll+50 < openingScroll ) {
							$(".headerlogo").removeClass("dark");
						} else {
							$(".headerlogo").addClass("dark");
						}

						// Accessibility
						if ( windowScroll+90 > openingScroll ) {
							$(".header-accessibility").addClass("dark");
						} else {
							$(".header-accessibility").removeClass("dark");
						}

						// Credits
						$(".credits").addClass("dark");

						// Social
						if ( windowScroll+(windowHeight/2)-30 < openingScroll ) {
							$(".social").removeClass("dark");
						} else {
							$(".social").addClass("dark");
						}
					} else {
						// Logo
						$(".headerlogo").addClass("dark");

						// Accessibility
						if ( windowScroll+30 > galleryScroll ) {
							$(".header-accessibility").addClass("dark");
						} else {
							$(".header-accessibility").removeClass("dark");
						}

						// Credits
						if ( windowScroll+windowHeight-30 > galleryScroll && windowScroll+windowHeight-30 < galleryScroll+galleryHeight ) {
							$(".credits").addClass("dark");
						} else {
							$(".credits").removeClass("dark");
						}

						// Social
						if ( windowScroll+(windowHeight/2)-30 > galleryScroll+galleryHeight ) {
							$(".social").removeClass("dark");
						} else {
							$(".social").addClass("dark");
						}
					}

					// Music
					if ( windowScroll+windowHeight-30 > galleryScroll+galleryHeight ) {
						$(".music").removeClass("dark");
					} else {
						$(".music").addClass("dark");
					}
				} else {
					$(".headerlogo, .music, .social").addClass("dark");
					$(".header-accessibility, .credits").removeClass("dark");
				}

			// Contact Page
			} else if ( $(".contact").length ) {
				if ( window.innerWidth < 1200 ) {
					$(".music, .social").removeClass("dark");
				} else {
					$(".music, .social").addClass("dark");
				}

			// Events Page
			} else if ( $(".events").length ) {
				$(".headerlogo, .social, .music").addClass("dark");
				if ( window.innerWidth < 1200 ) {
					if ( !$(".events-past").hasClass("open") ) {
						$(".header-accessibility, .credits").addClass("dark");
					}
				} else {
					$(".header-accessibility, .credits").removeClass("dark");
				}

			// Event Page
			} else if ( $(".event-wrapper").length ) {
				$(".headerlogo, .header-accessibility, .credits, .music, .social").addClass("dark");
			}
		}






















































	/***************************************************************
		Form Validation Functions
	***************************************************************/
	
		function removeDashed(number) {
			return number.replace(/-/g, "");
		}
		
		function onlyDigits(number) {
			var reg = new RegExp('^[0-9]+$');
			return reg.test(number);
		}
		
		function checkPhone(number) {
			if ( onlyDigits(number) ) {
				if ( number.length < 9 || number.length > 10 ) {
					return false;
				} else {
					if ( number.length == 10 ) {
						if ( number.substring(0, 2) != "05" && number.substring(0, 2) != "07" ) {
							return false;
						} else {
							return true;
						}
					} else {
						return true;
					}
				}
			} else {
				return false;
			}
		}
    
		function checkEmail(email) {
			var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			return re.test(email);
		}
    
    if (!String.prototype.startsWith) {
			String.prototype.startsWith = function(searchString, position){
				position = position || 0;
				return this.substr(position, searchString.length) === searchString;
			};
		}
    
    
    
	/***************************************************************
		Jump On Submit Fix
	***************************************************************/
	
		var scrollFromTop = $(window).scrollTop();
		
		$(window).scroll(function(){
			scrollFromTop = $(window).scrollTop();
		});
    
    
    
  /***************************************************************
		Form Validation
	***************************************************************/
		
		$("#contactForm").on("submit", function(event){
			event.preventDefault();
			
			var alertMessage = "";
			var contactValidationFlag = true;
			
			$(this).find(".input-wrapper.check").each(function(index){
				// if empty
				if ( $.trim( $(this).find("input").val() ) == "" ) {
					contactValidationFlag = false;
					$(this).addClass("error").find("span").text("׳©׳“׳” ׳–׳” ׳”׳™׳ ׳• ׳—׳•׳‘׳”");
          
				} else {
					// phone validation
					if ( $(this).hasClass("checkPhone") ) {
						var newNumber = removeDashed( $(this).find("input").val() );
						if ( !checkPhone( newNumber ) ) {
							contactValidationFlag = false;
							$(this).addClass("error").find("span").text("׳ ׳ ׳׳”׳–׳™׳ ׳׳¡׳₪׳¨ ׳˜׳׳₪׳•׳ ׳—׳•׳§׳™");
						} else {
							phoneAlertMessage = "";
							$(this).removeClass("error");
						}
						
					// email validation
					} else if ( $(this).hasClass("checkEmail") ) {
						if ( !checkEmail( $(this).find("input").val() ) ) {
							contactValidationFlag = false;
							$(this).addClass("error").find("span").text("׳ ׳ ׳׳”׳–׳™׳ ׳›׳×׳•׳‘׳× ׳“׳•׳\"׳ ׳×׳§׳™׳ ׳”");
						} else {
							emailAlertMessage = "";
							$(this).removeClass("error");
						}

					} else {
						$(this).removeClass("error");
					}
				}
			});
			
			$(window).scrollTop( scrollFromTop );
			if ( contactValidationFlag ) {
				$("#submitButton").addClass("active").prop("disabled", true);
				sendContactForm();
			}
		});




		$("#eventForm").on("submit", function(event){
			event.preventDefault();
			
			var alertMessage = "";
			var contactValidationFlag = true;
			
			$(this).find(".input-wrapper.check").each(function(index){
				// if empty
				if ( $.trim( $(this).find("input").val() ) == "" ) {
					contactValidationFlag = false;
					$(this).addClass("error").find("span").text("׳©׳“׳” ׳–׳” ׳”׳™׳ ׳• ׳—׳•׳‘׳”");
		        
				} else {
					// phone validation
					if ( $(this).hasClass("checkPhone") ) {
						var newNumber = removeDashed( $(this).find("input").val() );
						if ( !checkPhone( newNumber ) ) {
							contactValidationFlag = false;
							$(this).addClass("error").find("span").text("׳ ׳ ׳׳”׳–׳™׳ ׳׳¡׳₪׳¨ ׳˜׳׳₪׳•׳ ׳—׳•׳§׳™");
						} else {
							phoneAlertMessage = "";
							$(this).removeClass("error");
						}
						
					// email validation
					} else if ( $(this).hasClass("checkEmail") ) {
						if ( !checkEmail( $(this).find("input").val() ) ) {
							contactValidationFlag = false;
							$(this).addClass("error").find("span").text("׳ ׳ ׳׳”׳–׳™׳ ׳›׳×׳•׳‘׳× ׳“׳•׳\"׳ ׳×׳§׳™׳ ׳”");
						} else {
							emailAlertMessage = "";
							$(this).removeClass("error");
						}

					} else {
						$(this).removeClass("error");
					}
				}
			});
			
			$(window).scrollTop( scrollFromTop );
			if ( contactValidationFlag ) {
				$("#submitButton").addClass("active").prop("disabled", true);
				sendEventForm();
			}
		});


	
	/***************************************************************
		Send Form Function
	***************************************************************/
	
		function sendContactForm() {
			$.ajax( window.location.origin + "/wp-admin/admin-ajax.php", {
				method: "POST",
				data: {
					action: 'sendmail',
					mydata: $("form").serializeArray()
				},
				success: function(response){
					if (response == 1) {
						$("form")[0].reset();
						$("#submitButton").prop("disabled", false);
						$("#formWrapper").fadeOut(function(){
							$("#formSuccess").fadeIn();
						});
					} else {
						$("#submitButton").prop("disabled", false);
					}
				}
			});
		}


		function sendEventForm() {
			$.ajax( window.location.origin + "/wp-admin/admin-ajax.php", {
				method: "POST",
				data: {
					action: 'sendmail2',
					mydata: $("form").serializeArray()
				},
				success: function(response){
					if (response == 1) {
						$("form")[0].reset();
						$("#submitButton").prop("disabled", false);
						$("#formWrapper").fadeOut(function(){
							$("#formSuccess").fadeIn();
						});
					} else {
						$("#submitButton").prop("disabled", false);
					}
				}
			});
		}

	
});























/***************************************************************
	Google Map Functions
***************************************************************/

	function new_map($el) {
		var $markers = $el.find('.marker');
		
		var args = {
			zoom		: 16,
			center		: new google.maps.LatLng(0, 0),
			mapTypeId	: google.maps.MapTypeId.ROADMAP,
			disableDefaultUI: true,
			styles: [
				{
					"elementType": "geometry",
					"stylers": [
						{
							"color": "#f5f5f5"
						}
					]
				},
				{
					"elementType": "labels.icon",
					"stylers": [
						{
							"visibility": "off"
						}
					]
				},
				{
					"elementType": "labels.text.fill",
					"stylers": [
						{
							"color": "#616161"
						}
					]
				},
				{
					"elementType": "labels.text.stroke",
					"stylers": [
						{
							"color": "#f5f5f5"
						}
					]
				},
				{
					"featureType": "administrative.land_parcel",
					"elementType": "labels.text.fill",
					"stylers": [
						{
							"color": "#bdbdbd"
						}
					]
				},
				{
					"featureType": "poi",
					"elementType": "geometry",
					"stylers": [
						{
							"color": "#eeeeee"
						}
					]
				},
				{
					"featureType": "poi",
					"elementType": "labels.text.fill",
					"stylers": [
						{
							"color": "#757575"
						}
					]
				},
				{
					"featureType": "poi.park",
					"elementType": "geometry",
					"stylers": [
						{
							"color": "#e5e5e5"
						}
					]
				},
				{
					"featureType": "poi.park",
					"elementType": "labels.text.fill",
					"stylers": [
						{
							"color": "#9e9e9e"
						}
					]
				},
				{
					"featureType": "road",
					"elementType": "geometry",
					"stylers": [
						{
							"color": "#ffffff"
						}
					]
				},
				{
					"featureType": "road.arterial",
					"elementType": "labels.text.fill",
					"stylers": [
						{
							"color": "#757575"
						}
					]
				},
				{
					"featureType": "road.highway",
					"elementType": "geometry",
					"stylers": [
						{
							"color": "#dadada"
						}
					]
				},
				{
					"featureType": "road.highway",
					"elementType": "labels.text.fill",
					"stylers": [
						{
							"color": "#616161"
						}
					]
				},
				{
					"featureType": "road.local",
					"elementType": "labels.text.fill",
					"stylers": [
						{
							"color": "#9e9e9e"
						}
					]
				},
				{
					"featureType": "transit.line",
					"elementType": "geometry",
					"stylers": [
						{
							"color": "#e5e5e5"
						}
					]
				},
				{
					"featureType": "transit.station",
					"elementType": "geometry",
					"stylers": [
						{
							"color": "#eeeeee"
						}
					]
				},
				{
					"featureType": "water",
					"elementType": "geometry",
					"stylers": [
						{
							"color": "#c9c9c9"
						}
					]
				},
				{
					"featureType": "water",
					"elementType": "labels.text.fill",
					"stylers": [
						{
							"color": "#9e9e9e"
						}
					]
				}
			]
		};
		
		var map = new google.maps.Map($el[0], args);
		
		map.markers = [];
		$markers.each(function(){
			add_marker($(this), map);
		});
		
		center_map(map);
		
		return map;
	}

	function add_marker($marker, map) {
		var latlng = new google.maps.LatLng($marker.attr('data-lat'), $marker.attr('data-lng'));

		var marker = new google.maps.Marker({
			position	: latlng,
			icon		: "http://cocoon.co.il/wp-content/themes/cocoon/images/marker.png",
			map			: map
		});

		map.markers.push(marker);

		if($marker.html()) {
			var infowindow = new google.maps.InfoWindow({
				content		: $marker.html()
			});

			google.maps.event.addListener(marker, 'click', function() {
				infowindow.open(map, marker);
			});
		}
	}

	function center_map(map) {
		var bounds = new google.maps.LatLngBounds();

		$.each(map.markers, function(i, marker){
			var latlng = new google.maps.LatLng(marker.position.lat(), marker.position.lng());
			bounds.extend(latlng);
		});

		if(map.markers.length == 1) {
			map.setCenter(bounds.getCenter());
			map.setZoom(17);
		} else {
			map.fitBounds(bounds);
		}
	}