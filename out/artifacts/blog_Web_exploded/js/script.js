(function () {
    document.onmousemove = (e) => {
        let compass = document.getElementById('compass');
        compassClient = compass.getBoundingClientRect()

        let dx = compassClient.left + 30 - e.clientX;
        let dy = compassClient.top + 30 - e.clientY;
        let tan = dy / dx;
        let angle;
        if (dx >= 0) {
            angle = Math.atan(tan) * 57.2957795 + 180;
        }
        else {
            angle = Math.atan(tan) * 57.2957795;
        }
        document.getElementById('compass').style.transform = `rotate(${angle}deg)`;

    }


    document.getElementById('article_redirect').onclick = () => {
        document.getElementById('article_redirect').style = "top:120vh";
        let navBoxes = document.querySelectorAll(".navBox");
        console.log(navBoxes);
        for (let i = 0; i < navBoxes.length; i++) {
            console.log(this);
            if (navBoxes[i] != document.getElementById('article_redirect').querySelector('.navBox')){
                navBoxes[i].style = "z-index:998;";
            }
        }
        setTimeout(() => {
            window.location.href = "toBook";

        }, 1000);
    }
})();