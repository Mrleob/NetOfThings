// Generated code from Butter Knife. Do not modify!
package cn.tranway.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class LoginActivity$$ViewInjector {
  public static void inject(Finder finder, final cn.tranway.ui.LoginActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165193, "field 'mPassword'");
    target.mPassword = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131165190, "field 'mUphone'");
    target.mUphone = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131165197, "method 'toRegister'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.toRegister((android.widget.TextView) p0);
        }
      });
    view = finder.findRequiredView(source, 2131165194, "method 'login'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.login((android.widget.Button) p0);
        }
      });
  }

  public static void reset(cn.tranway.ui.LoginActivity target) {
    target.mPassword = null;
    target.mUphone = null;
  }
}
