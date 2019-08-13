(ns ui.core
  (:require [reagent.core :as reagent :refer [atom]]
            [ui.timer]
            [ui.item]))

(enable-console-print!)

(defn root-component []
  [:div
   [ui.timer/game-timer]
   [ui.item/items]])

(reagent/render
  [root-component]
  (js/document.getElementById "app-container"))
