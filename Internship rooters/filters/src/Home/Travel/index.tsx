import React from "react";
import style from "./Travel.module.css";

function Travel() {
    return (
        <div className={style.wrapper}>
            {/* <div className={style.image}>
                
                <div className={style.shadow}></div>
            </div> */}
            <div className={style.Rectangle}>
                <div className={style["bg-color"]}></div>
                <div className={style.left}></div>
                <div className={style.right}>
                    <div className={style.headshot}>Travel with Rooters</div>
                    <div className={style.tagline}>
                        Rooters introduces a whole new way of letting you travel
                        in style. With a custom fleet of buses offering
                        best-in-class facilities, we make no compromise when it
                        comes to comfort, safety and reliability for our
                        travellers.
                    </div>
                    <div className={style.icons}>
                        <div className={style.icon}>
                            <div className={style.location}></div>
                            <div className={style["icon-text"]}>
                                Live Location
                                <br />
                                Tracking
                            </div>
                        </div>
                        <div className={style.icon}>
                            <div className={style.time}></div>
                            <div className={style["icon-text"]}>
                                On-time
                                <br />
                                Departure
                            </div>
                        </div>
                        <div className={style.icon}>
                            <div className={style.wifi}></div>
                            <div className={style["icon-text"]}>
                                Hi speed
                                <br />
                                Wifi
                            </div>
                        </div>
                        <div className={style.icon}>
                            <div className={style.movie}></div>
                            <div className={style["icon-text"]}>
                                On-demand
                                <br />
                                movies
                            </div>
                        </div>
                        <div className={style.icon}>
                            <div className={style.support}></div>
                            <div className={style["icon-text"]}>
                                24X7
                                <br />
                                Support
                            </div>
                        </div>
                    </div>
                    <div className={style.Path}>
                        <div className={style["arrow-1"]}></div>
                        <div className={style["Learn-More"]}>Learn More</div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Travel;
