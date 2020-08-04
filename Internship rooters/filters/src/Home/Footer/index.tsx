import React from "react";
import style from "./footer.module.css";

function Footer() {
    return (
        <div className={style.wrapper}>
            <div className={style["top-section"]}>
                <div className={style["colomn"]}>
                    <div className={style.header}>Menu</div>
                    <div className={style.item}>About Rooters</div>
                    <div className={style.item}>Terms of service</div>
                    <div className={style.item}>Privacy policy</div>
                    <div className={style.item}>Terms and conditions</div>
                    <div className={style.item}>Help</div>
                </div>
                <div className={style["colomn"]}>
                    <div className={style.header}> </div>
                    <div className={style.item}>Blogs</div>
                    <div className={style.item}>FAQ</div>
                    <div className={style.item}>Career</div>
                    <div className={style.item}>Media</div>
                    <div className={style.item}>Offers</div>
                </div>
                <div className={style["colomn"]}>
                    <div className={style.header}>Contact</div>
                    <div className={style.item}>Phone number</div>
                    <div className={style.item}>+91 9606260074</div>
                    <div className={style.item}></div>
                    <div className={style.item}>Email Address</div>
                    <div className={style.item}>contact@rooters.in</div>
                </div>
                <div className={style["colomn"]}>
                    <div className={`${style.header} ${style.logo}`}></div>
                    <div className={style.item}></div>
                    <div className={style.item}>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor</div>
                    <div className={style.item}></div>
                    <div className={style.item}></div>
                    <div className={style.item}></div>
                </div>
            </div>
            <hr className={style["hr-line"]}/>
            <div className={style.footer}>
                Rooters Head office,  Bangalore, KA  -  560 034
            </div>
        </div>
    );
}

export default Footer;