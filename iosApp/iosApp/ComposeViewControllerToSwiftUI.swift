//
//  ComposeViewControllerToSwiftUI.swift
//  iosApp
//
//  Created by NHN on 2/17/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ComposeViewControllerToSwiftUI: UIViewControllerRepresentable {
    private let lifecycle: LifecycleRegistry
    private let topSafeArea: Float
    private let bottomSafeArea: Float
    
    init(lifecycle: LifecycleRegistry, topSafeArea: Float, bottomSafeArea: Float) {
         self.lifecycle = lifecycle
         self.topSafeArea = topSafeArea
         self.bottomSafeArea = bottomSafeArea
     }
    func makeUIViewController(context: Context) -> UIViewController {
         return Main_iosKt.MainViewController(
             lifecycle: lifecycle,
             topSafeArea: topSafeArea,
             bottomSafeArea: bottomSafeArea
         )
     }

     func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
     }
}
