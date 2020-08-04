import React from "react";
import style from "./Downloadapp.module.css";

function Downapp() {
    return (
        <div className={style.wrapper}>
            <div className={style["bg-color"]}></div>
            <div className={style.left}></div>
            <div className={style.right}>
                <div className={style.headshot}>Book tickets on the go</div>
                <div className={style.tagline}>
                    Download the rooters app available on android and iOS to
                    truely experience the rooters advantage.
                </div>
                <div className={style["icon-wrapper"]}>
                    <div className={style.googleplay}></div>
                    <div className={style.appstore}></div>
                </div>
            </div>
        </div>
    );
}
export default Downapp;
