import React from "react";
import style from "./Trending.module.css";

function Trending() {
    return (
        <div className={style.wrapper}>
            <div className={style.bg}></div>
            <div className={style["top-section"]}>
                <div className={style["headshot"]}>
                    <div className={style.heading}>Trending Destinations</div>
                    <div className={style["tagline"]}>
                        A curated list of the top trending destinations to help
                        plan your travel.{" "}
                    </div>
                </div>
                <div className={`${style.Tp1} ${style.tp}`}>
                    <div className={style["tp-box"]}>
                        <div className={style["TdName"]}>Mumbai</div>
                        <div className={style["Tdprices"]}>
                            Prices start from ₹800.00
                        </div>
                    </div>
                </div>
                <div className={`${style.Tp2} ${style.tp}`}>
                    <div className={style["tp-box"]}>
                        <div className={style["TdName"]}>Hyderabad</div>
                        <div className={style["Tdprices"]}>
                            Prices start from ₹600.00
                        </div>
                    </div>
                </div>
            </div>
            <div className={style["bottom-section"]}>
                <div className={`${style.Tp3} ${style.tp}`}>
                    <div className={style.BlurRectangle}>
                        <div className={style.BookNowRecta}>
                            <span className={style.arrow1}></span>
                            <span className={style.BookNow}>Book Now</span>
                        </div>
                    </div>
                    <div className={style["tp-box"]}>
                        <div className={style["TdName"]}>Udupi,Karnataka</div>
                        <div className={style["Tdprices"]}>
                            Prices start from ₹350.00
                        </div>
                    </div>
                </div>
                <div className={`${style.Tp4} ${style.tp}`}>
                    <div className={style["tp-box"]}>
                        <div className={style["TdName"]}>Coimbatore</div>
                        <div className={style["Tdprices"]}>
                            Prices start from ₹400.00
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Trending;
