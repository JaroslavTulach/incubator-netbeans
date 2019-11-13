<?php

namespace A;

function fa() {
    echo __FUNCTION__ . PHP_EOL;
}
function faa() {
    echo __FUNCTION__ . PHP_EOL;
}

namespace B;

function fb() {
    echo __FUNCTION__ . PHP_EOL;
}
function fbb() {
    echo __FUNCTION__ . PHP_EOL;
}

namespace C;

function fc() {
    echo __FUNCTION__ . PHP_EOL;
}
function fcc() {
    echo __FUNCTION__ . PHP_EOL;
}

namespace Run;

use \A\fa;
use \B\fb;
use \B\fbb;
use \C\fc;

fa();
fb();
fbb();
fc();
