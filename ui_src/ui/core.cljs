(ns ui.core
  (:require [reagent.core :as reagent :refer [atom]]
            [ui.timer]
            [ui.item]))

(enable-console-print!)

(defn root-component []
  [:div
   [ui.timer/game-timer]
   [ui.item/item :bow]
   [ui.item/item :bottle]
   [ui.item/item :boomerang]])

(reagent/render
  [root-component]
  (js/document.getElementById "app-container"))
