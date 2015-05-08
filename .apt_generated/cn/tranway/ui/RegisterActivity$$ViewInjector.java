// Generated code from Butter Knife. Do not modify!
package cn.tranway.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class RegisterActivity$$ViewInjector {
  public static void inject(Finder finder, final cn.tranway.ui.RegisterActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165209, "field 'mUpassWord'");
    target.mUpassWord = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131165207, "field 'mUphone'");
    target.mUphone = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131165211, "field 'mUpassWordAgain'");
    target.mUpassWordAgain = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131165212, "method 'register'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.register();
        }
      });
  }

  public static void reset(cn.tranway.ui.RegisterActivity target) {
    target.mUpassWord = null;
    target.mUphone = null;
    target.mUpassWordAgain = null;
  }
}
