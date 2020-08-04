import React from "react";
import style from "./Exclusive.module.css";

function Exclusive() {
    return (
        <div className={style.wrapper}>
            <div className={style.headshot}>Exclusive Offers</div>
            <div className={style.tagline}>
                To get you moving,Rooters is more than happy to bring in
                unbelievable offers that you just can't say no to.
            </div>
            <div className={style["mid-section"]}>
                <div className={style.bgstrip}></div>
                <div className={style.image1}>
                    <div className={style.image1discount}>
                        Exclusive: Flat 20% Off on your first ride
                    </div>
                    <div className={style.image1content}>
                        Get your first ride with us at a special price and
                        travel in style.
                    </div>
                    <div className={style["coupon-refer"]}>
                        <div className={style.couponcode}>COUPON CODE</div>
                        <div className={style.Rectangle1}>
                            <div className={style.firstride20}>FIRSTRIDE20</div>
                        </div>
                    </div>
                </div>
                <div className={style.image2}>
                    <div className={style.image2discount}>
                        Special and exclusive offers only for New users.
                    </div>
                    <div className={style.image2content}>
                        Register with us and avail unbelievable offers only on
                        Rooters.
                    </div>
                    <div className={`${style["coupon-refer"]} ${style["extra-padding"]}`}>
                      <div className={style.Rectangle2}>
                          <div className={style.signup}>SIGNUP</div>
                      </div>
                    </div>
                </div>
                <div className={style.image3}>
                    <div className={style.image1discount}>
                        Exclusive: Flat 20% Off on your first ride
                    </div>
                    <div className={style.image1content}>
                        Get your first ride with us at a special price and
                        travel in style.
                    </div>
                    <div className={style["coupon-refer"]}>
                        <div className={style.couponcode}>COUPON CODE</div>
                        <div className={style.Rectangle1}>
                            <div className={style.firstride20}>FIRSTRIDE20</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Exclusive;
