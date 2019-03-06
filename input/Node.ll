; ModuleID = 'Node.c'
source_filename = "Node.c"
target datalayout = "e-m:e-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%struct.Node_struct = type { i32, i32, i32, i32, i32, i32, %struct.Node_struct*, %struct.Node_struct*, i32 }

; Function Attrs: noinline nounwind optnone uwtable
define void @Node_add(i32, %struct.Node_struct*) #0 {
  %3 = alloca i32, align 4
  %4 = alloca %struct.Node_struct*, align 8
  store i32 %0, i32* %3, align 4
  store %struct.Node_struct* %1, %struct.Node_struct** %4, align 8
  %5 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %6 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %5, i32 0, i32 6
  %7 = load %struct.Node_struct*, %struct.Node_struct** %6, align 8
  %8 = icmp ne %struct.Node_struct* %7, null
  br i1 %8, label %9, label %15

; <label>:9:                                      ; preds = %2
  %10 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %11 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %10, i32 0, i32 8
  store i32 1, i32* %11, align 8
  %12 = load i32, i32* %3, align 4
  %13 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %14 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %13, i32 0, i32 5
  store i32 %12, i32* %14, align 4
  br label %62

; <label>:15:                                     ; preds = %2
  %16 = load i32, i32* %3, align 4
  %17 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %18 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %17, i32 0, i32 4
  %19 = load i32, i32* %18, align 8
  %20 = icmp slt i32 %16, %19
  br i1 %20, label %21, label %39

; <label>:21:                                     ; preds = %15
  %22 = load i32, i32* %3, align 4
  %23 = call i32 (i32, ...) bitcast (i32 (...)* @Node_init to i32 (i32, ...)*)(i32 %22)
  %24 = sext i32 %23 to i64
  %25 = inttoptr i64 %24 to %struct.Node_struct*
  %26 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %27 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %26, i32 0, i32 6
  store %struct.Node_struct* %25, %struct.Node_struct** %27, align 8
  %28 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %29 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %28, i32 0, i32 4
  %30 = load i32, i32* %29, align 8
  %31 = call i32 (i32, ...) bitcast (i32 (...)* @Node_init to i32 (i32, ...)*)(i32 %30)
  %32 = sext i32 %31 to i64
  %33 = inttoptr i64 %32 to %struct.Node_struct*
  %34 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %35 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %34, i32 0, i32 7
  store %struct.Node_struct* %33, %struct.Node_struct** %35, align 8
  %36 = load i32, i32* %3, align 4
  %37 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %38 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %37, i32 0, i32 4
  store i32 %36, i32* %38, align 8
  br label %61

; <label>:39:                                     ; preds = %15
  %40 = load i32, i32* %3, align 4
  %41 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %42 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %41, i32 0, i32 4
  %43 = load i32, i32* %42, align 8
  %44 = icmp sgt i32 %40, %43
  br i1 %44, label %45, label %60

; <label>:45:                                     ; preds = %39
  %46 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %47 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %46, i32 0, i32 4
  %48 = load i32, i32* %47, align 8
  %49 = call i32 (i32, ...) bitcast (i32 (...)* @Node_init to i32 (i32, ...)*)(i32 %48)
  %50 = sext i32 %49 to i64
  %51 = inttoptr i64 %50 to %struct.Node_struct*
  %52 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %53 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %52, i32 0, i32 6
  store %struct.Node_struct* %51, %struct.Node_struct** %53, align 8
  %54 = load i32, i32* %3, align 4
  %55 = call i32 (i32, ...) bitcast (i32 (...)* @Node_init to i32 (i32, ...)*)(i32 %54)
  %56 = sext i32 %55 to i64
  %57 = inttoptr i64 %56 to %struct.Node_struct*
  %58 = load %struct.Node_struct*, %struct.Node_struct** %4, align 8
  %59 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %58, i32 0, i32 7
  store %struct.Node_struct* %57, %struct.Node_struct** %59, align 8
  br label %60

; <label>:60:                                     ; preds = %45, %39
  br label %61

; <label>:61:                                     ; preds = %60, %21
  br label %62

; <label>:62:                                     ; preds = %61, %9
  ret void
}

declare i32 @Node_init(...) #1

; Function Attrs: noinline nounwind optnone uwtable
define i32 @Node_has(i32, %struct.Node_struct*) #0 {
  %3 = alloca i32, align 4
  %4 = alloca i32, align 4
  %5 = alloca %struct.Node_struct*, align 8
  store i32 %0, i32* %4, align 4
  store %struct.Node_struct* %1, %struct.Node_struct** %5, align 8
  %6 = load %struct.Node_struct*, %struct.Node_struct** %5, align 8
  %7 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %6, i32 0, i32 6
  %8 = load %struct.Node_struct*, %struct.Node_struct** %7, align 8
  %9 = icmp eq %struct.Node_struct* %8, null
  br i1 %9, label %10, label %17

; <label>:10:                                     ; preds = %2
  %11 = load i32, i32* %4, align 4
  %12 = load %struct.Node_struct*, %struct.Node_struct** %5, align 8
  %13 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %12, i32 0, i32 4
  %14 = load i32, i32* %13, align 8
  %15 = icmp eq i32 %11, %14
  %16 = zext i1 %15 to i32
  store i32 %16, i32* %3, align 4
  br label %35

; <label>:17:                                     ; preds = %2
  %18 = load i32, i32* %4, align 4
  %19 = load %struct.Node_struct*, %struct.Node_struct** %5, align 8
  %20 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %19, i32 0, i32 4
  %21 = load i32, i32* %20, align 8
  %22 = icmp sle i32 %18, %21
  br i1 %22, label %23, label %29

; <label>:23:                                     ; preds = %17
  %24 = load i32, i32* %4, align 4
  %25 = load %struct.Node_struct*, %struct.Node_struct** %5, align 8
  %26 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %25, i32 0, i32 6
  %27 = load %struct.Node_struct*, %struct.Node_struct** %26, align 8
  %28 = call i32 @Node_has(i32 %24, %struct.Node_struct* %27)
  store i32 %28, i32* %3, align 4
  br label %35

; <label>:29:                                     ; preds = %17
  %30 = load i32, i32* %4, align 4
  %31 = load %struct.Node_struct*, %struct.Node_struct** %5, align 8
  %32 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %31, i32 0, i32 7
  %33 = load %struct.Node_struct*, %struct.Node_struct** %32, align 8
  %34 = call i32 @Node_has(i32 %30, %struct.Node_struct* %33)
  store i32 %34, i32* %3, align 4
  br label %35

; <label>:35:                                     ; preds = %29, %23, %10
  %36 = load i32, i32* %3, align 4
  ret i32 %36
}

; Function Attrs: noinline nounwind optnone uwtable
define void @Node_addToChild(%struct.Node_struct*) #0 {
  %2 = alloca %struct.Node_struct*, align 8
  store %struct.Node_struct* %0, %struct.Node_struct** %2, align 8
  %3 = load %struct.Node_struct*, %struct.Node_struct** %2, align 8
  %4 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %3, i32 0, i32 5
  %5 = load i32, i32* %4, align 4
  %6 = load %struct.Node_struct*, %struct.Node_struct** %2, align 8
  %7 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %6, i32 0, i32 4
  %8 = load i32, i32* %7, align 8
  %9 = icmp sle i32 %5, %8
  br i1 %9, label %10, label %17

; <label>:10:                                     ; preds = %1
  %11 = load %struct.Node_struct*, %struct.Node_struct** %2, align 8
  %12 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %11, i32 0, i32 5
  %13 = load i32, i32* %12, align 4
  %14 = load %struct.Node_struct*, %struct.Node_struct** %2, align 8
  %15 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %14, i32 0, i32 6
  %16 = load %struct.Node_struct*, %struct.Node_struct** %15, align 8
  call void @Node_add(i32 %13, %struct.Node_struct* %16)
  br label %24

; <label>:17:                                     ; preds = %1
  %18 = load %struct.Node_struct*, %struct.Node_struct** %2, align 8
  %19 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %18, i32 0, i32 5
  %20 = load i32, i32* %19, align 4
  %21 = load %struct.Node_struct*, %struct.Node_struct** %2, align 8
  %22 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %21, i32 0, i32 7
  %23 = load %struct.Node_struct*, %struct.Node_struct** %22, align 8
  call void @Node_add(i32 %20, %struct.Node_struct* %23)
  br label %24

; <label>:24:                                     ; preds = %17, %10
  %25 = load %struct.Node_struct*, %struct.Node_struct** %2, align 8
  %26 = getelementptr inbounds %struct.Node_struct, %struct.Node_struct* %25, i32 0, i32 8
  store i32 0, i32* %26, align 8
  ret void
}

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0}
!llvm.ident = !{!1}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"}
