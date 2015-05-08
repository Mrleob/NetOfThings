// Generated code from Butter Knife. Do not modify!
package cn.tranway.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final cn.tranway.ui.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165201, "method 'showOrbit'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.showOrbit((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131165200, "method 'showLocation'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.showLocation((android.widget.Button) p0);
        }
      });
  }

  public static void reset(cn.tranway.ui.MainActivity target) {
  }
}
