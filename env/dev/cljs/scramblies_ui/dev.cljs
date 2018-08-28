(ns ^:figwheel-no-load scramblies-ui.dev
  (:require
    [scramblies-ui.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
