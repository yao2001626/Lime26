; ModuleID = 'Reducer.c'
source_filename = "Reducer.c"
target datalayout = "e-m:o-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-apple-macosx10.12.0"

%struct.Reducer_struct = type { i32, i32, i32, i32, i32, %struct.Reducer_struct*, i32, i32, i32, i32 }

; Function Attrs: norecurse nounwind optsize ssp uwtable
define void @Reducer_reduce1(i32, %struct.Reducer_struct* nocapture) local_unnamed_addr #0 {
  %3 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %1, i64 0, i32 8
  store i32 %0, i32* %3, align 8, !tbaa !3
  %4 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %1, i64 0, i32 6
  store i32 1, i32* %4, align 8, !tbaa !9
  ret void
}

; Function Attrs: norecurse nounwind optsize ssp uwtable
define void @Reducer_reduce2(i32, %struct.Reducer_struct* nocapture) local_unnamed_addr #0 {
  %3 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %1, i64 0, i32 9
  store i32 %0, i32* %3, align 4, !tbaa !10
  %4 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %1, i64 0, i32 7
  store i32 1, i32* %4, align 4, !tbaa !11
  ret void
}

; Function Attrs: norecurse nounwind optsize ssp uwtable
define void @Reducer_doReduce(%struct.Reducer_struct* nocapture) local_unnamed_addr #0 {
  %2 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %0, i64 0, i32 4
  %3 = load i32, i32* %2, align 8, !tbaa !12
  %4 = and i32 %3, 1
  %5 = icmp eq i32 %4, 0
  %6 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %0, i64 0, i32 8
  %7 = load i32, i32* %6, align 8, !tbaa !3
  %8 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %0, i64 0, i32 9
  %9 = load i32, i32* %8, align 4, !tbaa !10
  %10 = add nsw i32 %9, %7
  %11 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %0, i64 0, i32 5
  %12 = load %struct.Reducer_struct*, %struct.Reducer_struct** %11, align 8, !tbaa !13
  br i1 %5, label %13, label %16

; <label>:13:                                     ; preds = %1
  %14 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %12, i64 0, i32 8
  store i32 %10, i32* %14, align 8, !tbaa !3
  %15 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %12, i64 0, i32 6
  store i32 1, i32* %15, align 8, !tbaa !9
  br label %19

; <label>:16:                                     ; preds = %1
  %17 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %12, i64 0, i32 9
  store i32 %10, i32* %17, align 4, !tbaa !10
  %18 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %12, i64 0, i32 7
  store i32 1, i32* %18, align 4, !tbaa !11
  br label %19

; <label>:19:                                     ; preds = %16, %13
  %20 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %0, i64 0, i32 6
  store i32 0, i32* %20, align 8, !tbaa !9
  %21 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %0, i64 0, i32 7
  store i32 0, i32* %21, align 4, !tbaa !11
  ret void
}

attributes #0 = { norecurse nounwind optsize ssp uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="true" "no-frame-pointer-elim-non-leaf" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+fxsr,+mmx,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0, !1}
!llvm.ident = !{!2}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{i32 7, !"PIC Level", i32 2}
!2 = !{!"clang version 5.0.0 (tags/RELEASE_500/final)"}
!3 = !{!4, !5, i64 40}
!4 = !{!"Reducer_struct", !5, i64 0, !5, i64 4, !5, i64 8, !5, i64 12, !5, i64 16, !8, i64 24, !5, i64 32, !5, i64 36, !5, i64 40, !5, i64 44}
!5 = !{!"int", !6, i64 0}
!6 = !{!"omnipotent char", !7, i64 0}
!7 = !{!"Simple C/C++ TBAA"}
!8 = !{!"any pointer", !6, i64 0}
!9 = !{!4, !5, i64 32}
!10 = !{!4, !5, i64 44}
!11 = !{!4, !5, i64 36}
!12 = !{!4, !5, i64 16}
!13 = !{!4, !8, i64 24}
