(function () {
    let tags = document.querySelectorAll('.tags');
    for(let i = 0;i<tags.length;i++){
        let temp = tags[i].innerHTML;
        tags[i].innerHTML = `&nbsp&nbsp${temp}&nbsp&nbsp`;
    }
    let articleContainer = document.getElementById('articleContainer');
    let Allarticles = articleContainer.querySelectorAll('.articleBox');
    let page = 1;
    let pageNum = document.getElementById('pageNum').value;
    if(pageNum!=''){
        page = parseInt(pageNum);
    }
    let leftPageInner = document.createElement('div');
    leftPageInner.className = "innerpage";
    let rightPageInner = document.createElement('div');
    rightPageInner.className = "innerpage";
    let startIndex = (page - 1) * 6;
    let lastPage = parseInt(Allarticles.length / 6)+1;
    let BeforeleftPageInner = document.createElement('div');
    let BeforerightPageInner = document.createElement('div');
    let AfterleftPageInner = document.createElement('div');
    let AfterrightPageInner = document.createElement('div');
    BeforeleftPageInner.className = "innerpage";
    BeforerightPageInner.className = "innerpage";
    AfterleftPageInner.className = "innerpage";
    AfterrightPageInner.className = "innerpage";
    // for(let i = 0;i<Allarticles.length;i++){
    //     Allarticles[i].setAttribute("num",i+1);
    // }
    function generatePages() {
       
        startIndex = (page - 1) * 6;
        leftPageInnerStr = ``;
        rightPageInnerStr = ``;
        for (let i = (page - 1) * 6; i < Allarticles.length && i < page * 6; i++) {
 
            while (i - startIndex < 3&&i<Allarticles.length) {
                leftPageInnerStr += Allarticles[i].outerHTML;
                i++;
            }
            if(i==Allarticles.length)break;
            rightPageInnerStr += Allarticles[i].outerHTML;
        }
        leftPageInner.innerHTML = leftPageInnerStr;
        rightPageInner.innerHTML = rightPageInnerStr;
        if (page === 1) {//is the first page
            document.getElementById('leftButton').style = "display:none;";
        }
        else {//generate the former page
            document.getElementById('leftButton').style = "";
            let pageB = page - 1;
            let startIndex = (pageB - 1) * 6;
            let BeforeleftPageInnerStr = ``;
            let BeforerightPageInnerStr = ``;
            for (let i = (pageB - 1) * 6; i < Allarticles.length && i < pageB * 6; i++) {

                while (i - startIndex < 3&&i<Allarticles.length) {
                    BeforeleftPageInnerStr += Allarticles[i].outerHTML;
                    i++;
                }
            if(i==Allarticles.length)break;

                BeforerightPageInnerStr += Allarticles[i].outerHTML;
            }
            BeforeleftPageInner.innerHTML = BeforeleftPageInnerStr;
            BeforerightPageInner.innerHTML = BeforerightPageInnerStr;
        }
        if (page === lastPage) {//is the last page
            document.getElementById('rightButton').style = "display:none;";
        }
        else {
            document.getElementById('rightButton').style = "";
            let pageA = page + 1;
            let startIndex = (pageA - 1) * 6;
            let AfterleftPageInnerStr = ``;
            let AfterrightPageInnerStr = ``;
            for (let i = (pageA - 1) * 6; i < Allarticles.length && i < pageA * 6; i++) {

                while (i - startIndex < 3&&i < Allarticles.length) {
                    AfterleftPageInnerStr += Allarticles[i].outerHTML;
                    i++;
                }
                if(i == Allarticles.length){
                    break;
                }
                AfterrightPageInnerStr += Allarticles[i].outerHTML;
            }
            AfterleftPageInner.innerHTML = AfterleftPageInnerStr;
            AfterrightPageInner.innerHTML = AfterrightPageInnerStr;
        }

        document.getElementById('leftPage').innerHTML = leftPageInner.outerHTML;
        document.getElementById('rightPage').innerHTML = rightPageInner.outerHTML;
        let articleBoxes = document.querySelectorAll('.articleBox');
        for (let i = 0; i < articleBoxes.length; i++) {
            articleBoxes[i].onclick = (e) => {
                setTimeout(() => {
                    window.location.href = `/article?num=${articleBoxes[i].getAttribute('num')}&back=${page}`;
                }, 1000);
                let click_cover = document.querySelector('.click_cover');
                click_cover.style = `left:${e.clientX}px;top:${e.clientY}px;transform:scale(200)`;
            }
        }
    }
    generatePages();

    let urlParam = window.location.search;
    if (urlParam.includes("back")) {
        document.querySelector('.return_cover').style = 'display:block;';
        setTimeout(() => {
            document.querySelector('.return_cover').classList.add('scaleDown');
        }, 100);
    }

    let buttonLock = false;

    function generateFlip1(flipOver) {//right
        let innerflips = document.querySelectorAll('.flip>.innerflip');
        for (let i = 0; i < innerflips.length; i++) {
            innerflips[i].innerHTML = flipOver;
            innerflips[i].querySelector('.innerpage').style = `margin-left: -${-29 + 50 * (13 - i)}px;`;
            if (i == 13) {
                innerflips[i].style = "padding-left:4px;";
            }
        }
        let articleBox = document.querySelectorAll('#flip .articleBox');//address display bug while flipping
        for (let i = 0; i < articleBox.length; i++) {
            articleBox[i].style = "pointer-events: none;";
        }
    }
    function generateFlip2(flipBefore) {//left
        let innerflips = document.querySelectorAll('.flip .f2nest>.innerflip');
        for (let i = 0; i < innerflips.length; i++) {
            innerflips[i].innerHTML = flipBefore;
            innerflips[i].querySelector('.innerpage').style = `margin-left: -${-25 + 50 * (i)}px;`;

        }
        let articleBox = document.querySelectorAll('#flip .articleBox');
        for (let i = 0; i < articleBox.length; i++) {
            articleBox[i].style = "pointer-events: none;";
        }

    }

    let leftButton = document.getElementById('leftButton');
    leftButton.onclick = () => {
        if (buttonLock) return;
        buttonLock = true;
        page--;
        generateFlip1(leftPageInner.outerHTML);
        generateFlip2(BeforerightPageInner.outerHTML);

        document.getElementById('flip').style = 'display:block';
        let flip1 = document.querySelectorAll('.flip1');
        let flip2 = document.querySelectorAll('.flip1 .flip')
        for (let i = 0; i < flip1.length; i++) {
            flip1[i].classList.add('fl1_an1');
        }
        for (let i = 0; i < flip2.length; i++) {
            flip2[i].classList.add('fl2_an1');
        }
        document.getElementById('leftPage').innerHTML = BeforeleftPageInner.outerHTML;

        setTimeout(() => {
            document.getElementById('rightPage').innerHTML = BeforerightPageInner.outerHTML;
            generatePages();
            buttonLock = false;
        }, 3000);
        let flips = document.querySelectorAll('.flip');
        for (let i = 0; i < flips.length; i++) {
            flips[i].style = "display:block;";
            flips[i].style = "animation-play-state:running;"
            setTimeout(() => {
                flips[i].style = "animation-play-state:paused;"
                flips[i].style = "display:none;";
                for (let i = 0; i < flip1.length; i++) {
                    flip1[i].classList.remove('fl1_an1');
                }
                for (let i = 0; i < flip2.length; i++) {
                    flip2[i].classList.remove('fl2_an1');
                }
            }, 3000);

        }
    }
    let rightButton = document.getElementById('rightButton');
    rightButton.onclick = () => {
        if (buttonLock) return;
        buttonLock = true;
        page++;
        generateFlip1(AfterleftPageInner.outerHTML);
        generateFlip2(rightPageInner.outerHTML);

        document.getElementById('flip').style = 'display:block';
        let flip1 = document.querySelectorAll('.flip1');
        let flip2 = document.querySelectorAll('.flip1 .flip')
        for (let i = 0; i < flip1.length; i++) {
            flip1[i].classList.add('fl1_an2');
        }
        for (let i = 0; i < flip2.length; i++) {
            flip2[i].classList.add('fl2_an2');
        }
        document.getElementById('rightPage').innerHTML = AfterrightPageInner.outerHTML;
        setTimeout(() => {
            document.getElementById('leftPage').innerHTML = AfterleftPageInner.outerHTML;
            generatePages();
            buttonLock = false;
        }, 3000);
        let flips = document.querySelectorAll('.flip');
        for (let i = 0; i < flips.length; i++) {
            flips[i].style = "display:block;";
            flips[i].style = "animation-play-state:running;"
            setTimeout(() => {
                flips[i].style = "animation-play-state:paused;"
                flips[i].style = "display:none;";
                for (let i = 0; i < flip1.length; i++) {
                    flip1[i].classList.remove('fl1_an2');
                }
                for (let i = 0; i < flip2.length; i++) {
                    flip2[i].classList.remove('fl2_an2');
                }
            }, 3000);
        }
    }

    document.getElementById('backIcon').onclick = ()=>{
        window.location.href = `/index`;
    }
    
})()