import React from "react";
import Header from "./Header";
import Trending from "./Trending";
import Footer from "./Footer";
import Blogs from "./Blogs";
import Exclusive from "./Exclusives";
import DownloadApp from "./Downloadapp";
import Travel from "./Travel";

function Home() {
    return (
        <div>
            <Header />
            <Travel />
            <Exclusive />
            <Trending />
            <Blogs />
            <DownloadApp />
            <Footer />
        </div>
    )
}

export default Home;
