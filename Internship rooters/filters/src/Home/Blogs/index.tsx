import React from "react";
import style from "./Blogs.module.css";

function Blogs() {
    return (
        <div className={style.wrapper}>
            <div className={style["top-image"]}></div>
            <div className={style["content-wrapper"]}>
                <div className={style.bg}></div>
                <div className={style["top-section"]}>
                    <div className={style.text}>
                        <div className={style.headshot}>Blogs</div>
                        <div className={style.tag}>
                            Get to know the latest in tech and travel. Subscribe
                            to our newsletter to stay updated.
                        </div>
                        <div className={style.Path}>
                            <span>
                                <div className={style["arrow-1"]}></div>
                            </span>
                            <span className={style["View-all"]}>View all</span>
                        </div>
                    </div>

                    <div className={style["image-1"]}>
                        {/* <div className={style["Rectangle-blur"]}></div> */}
                        <div className={style.Rectangle}>
                            <div className={style["Why-travelling-with"]}>
                                Why travelling with strangers will change your
                                world
                            </div>
                            <div className={style["Lorem-ipsum-dolor-si"]}>
                                Lorem ipsum dolor sit amet, consectetur
                                adipiscing elit, sed do eiusmod tempor
                                incididunt{" "}
                            </div>
                            <div className={style["mins-read"]}>
                                8 mins read
                            </div>
                        </div>
                    </div>
                </div>
                <div className={style["bottom-section"]}>
                    <div className={style["image-2"]}>
                        {/* <div className={style["Rectangle-blur"]}></div> */}
                        <div className={style.Rectangle}>
                            <div className={style["Why-travelling-with"]}>
                                Why travelling with strangers will change your
                                world
                            </div>
                            <div className={style["Lorem-ipsum-dolor-si"]}>
                                Lorem ipsum dolor sit amet, consectetur
                                adipiscing elit, sed do eiusmod tempor
                                incididunt{" "}
                            </div>
                            <div className={style["-mins-read"]}>
                                8 mins read
                            </div>
                        </div>
                    </div>
                    <div className={style["right-section"]}>
                        <div className={style["side-box-1"]}>
                            <div className={style["image-3"]}></div>
                            <div className={style["text-section"]}>
                                <div className={style["Why-travelling-with-1"]}>
                                    Why travelling with strangers will change
                                    your world
                                </div>
                                <div
                                    className={style["Lorem-ipsum-dolor-si-1"]}
                                >
                                    Lorem ipsum dolor sit amet, consectetur
                                    adipiscing elit, sed do eiusmod tempor
                                    incididunt{" "}
                                </div>
                                <div className={style["mins-read-1"]}>
                                    8 mins read
                                </div>
                                <hr />
                            </div>
                        </div>
                        <div className={style["line-1"]}></div>
                        <div className={style["side-box-1"]}>
                            <div className={`${style["image-3"]} ${style["image-4"]}`}></div>
                            <div className={style["text-section"]}>
                                <div className={style["Why-travelling-with-1"]}>
                                    Why travelling with strangers will change
                                    your world
                                </div>
                                <div
                                    className={style["Lorem-ipsum-dolor-si-1"]}
                                >
                                    Lorem ipsum dolor sit amet, consectetur
                                    adipiscing elit, sed do eiusmod tempor
                                    incididunt{" "}
                                </div>
                                <div className={style["mins-read-1"]}>
                                    8 mins read
                                </div>
                                <hr/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Blogs;
